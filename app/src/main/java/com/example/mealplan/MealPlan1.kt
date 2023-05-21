package com.example.mealplan
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
class MealPlan1 : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var firestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal_plan1)

        listView = findViewById(R.id.listView)
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1)
        listView.adapter = adapter

        firestore = FirebaseFirestore.getInstance()

        val currentUser = FirebaseAuth.getInstance().currentUser
        val uid = currentUser?.uid

        if (uid != null) {
            val mealPlanCollection = firestore.collection("users").document(uid).collection("Mealplan")

            mealPlanCollection.addSnapshotListener { querySnapshot, firebaseFirestoreException ->
                if (firebaseFirestoreException != null) {
                    // Handle any errors
                    return@addSnapshotListener
                }

                adapter.clear()

                for (document in querySnapshot!!) {
                    val name = document.getString("name")
                    if (name != null) {
                        adapter.add(name)
                    }
                }

                adapter.notifyDataSetChanged()
            }
        }
    }
}