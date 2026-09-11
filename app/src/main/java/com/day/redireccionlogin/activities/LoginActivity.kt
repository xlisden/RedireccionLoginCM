package com.day.redireccionlogin.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.day.redireccionlogin.MainActivity
import com.day.redireccionlogin.R
import com.day.redireccionlogin.databinding.ActivityLoginBinding
import com.day.redireccionlogin.utils.SessionManager
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {

    private val USERNAME_DEFAULT = "admin"
    private val PASSSWORD_DEFAULT = "123456"

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sessionManager = SessionManager(this)

        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()

            if (username == USERNAME_DEFAULT && password == PASSSWORD_DEFAULT) {
                sessionManager.isLogged()
                navigateToMain()
            } else {
                showErrMsg(binding.root)
            }
        }
    }

    private fun navigateToMain() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun showErrMsg(view: View) {
        Snackbar.make(view, "User not found", Snackbar.LENGTH_SHORT).show()
    }
}