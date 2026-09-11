package com.day.redireccionlogin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.day.redireccionlogin.activities.LoginActivity
import com.day.redireccionlogin.databinding.ActivityLoginBinding
import com.day.redireccionlogin.databinding.ActivityMainBinding
import com.day.redireccionlogin.utils.SessionManager

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sessionManager = SessionManager(this)

        binding.btnLogout.setOnClickListener {
            sessionManager.closeSession()
            navigateToLogin()
        }
    }

    fun navigateToLogin() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}