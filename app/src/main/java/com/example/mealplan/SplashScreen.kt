package com.example.mealplan

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        val thread: Thread = object : Thread() {
            override fun run() {
                try {
                    sleep(2000)
                } catch (e: Exception) {
                    e.printStackTrace()
                } finally {
                    val newIntent = Intent(this@SplashScreen, MainActivity::class.java)
                    startActivity(newIntent)
                    overridePendingTransition(R.anim.fade_in2, R.anim.fade_out2)
                    finish()
                }

            }
        }
        thread.start()
    }
}