package com.example.jokenpo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val hide = supportActionBar?.hide()

        img1.visibility = View.GONE
        textJo.visibility = View.GONE

        img2.visibility = View.GONE
        textKen.visibility = View.GONE

        img3.visibility = View.GONE
        textPo.visibility = View.GONE

        Handler().postDelayed(object : Runnable {
            override fun run() {
            img1.visibility = View.VISIBLE
            textJo.visibility = View.VISIBLE
            }
        }, DELAYED)


        Handler().postDelayed(object : Runnable {
            override fun run() {
                img2.visibility = View.VISIBLE
                textKen.visibility = View.VISIBLE

            }
        }, DELAYED2)


        Handler().postDelayed(object : Runnable {
            override fun run() {
                img3.visibility = View.VISIBLE
                textPo.visibility = View.VISIBLE
                intent = Intent(this@SplashScreenActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }, DELAYED3)


    }
    companion object{
        const val DELAYED:Long = 1000
        const val DELAYED2:Long = 2000
        const val DELAYED3:Long = 3000
    }
}
