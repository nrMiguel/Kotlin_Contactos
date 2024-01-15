package com.example.icb0007_uf1_pr01_miguelnunezramon1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.concurrent.thread

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // No consigo que esto rule, pasando...
        try{
            Thread.sleep(3000)
        } catch (e: InterruptedException){}

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

        }
    }
