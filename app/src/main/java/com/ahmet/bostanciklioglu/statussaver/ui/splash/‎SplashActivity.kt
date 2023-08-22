package com.ahmet.bostanciklioglu.statussaver.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.ahmet.bostanciklioglu.statussaver.ui.home.activity.MainActivity
import com.ahmet.bostanciklioglu.statussaver.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    companion object {
        private val SPLASH_DELAY = 2000L
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler(Looper.getMainLooper()).postDelayed({
            MainActivity.startMainActivity(this)
        }, SPLASH_DELAY)
    }
}