package com.example.mealplan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val thread = Thread {
            try {
                Thread.sleep(2000)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                val newIntent = Intent(this@SplashScreen, MainActivity::class.java)
                startActivity(newIntent)
                overridePendingTransition(R.anim.fade_in2, R.anim.fade_out2)
                finish()
            }
        }
        thread.start()
    }
}