package com.day.redireccionlogin.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.day.redireccionlogin.MainActivity
import com.day.redireccionlogin.R
import com.day.redireccionlogin.databinding.ActivitySplashBinding
import com.day.redireccionlogin.utils.SessionManager

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val sessionManager = SessionManager(this)
        val intent: Intent

        if (sessionManager.isLogged()) {
            intent = Intent(this, MainActivity::class.java)
        } else {
            intent = Intent(this, LoginActivity::class.java)
        }
        startActivity(intent)
        finish()
    }
}