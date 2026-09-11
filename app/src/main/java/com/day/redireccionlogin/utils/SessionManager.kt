package com.day.redireccionlogin.utils

import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {

    private val preferences: SharedPreferences = context.getSharedPreferences("AppPrefs", Context.MODE_PRIVATE)

    fun createSession(username: String) {
        val editor = preferences.edit()

        editor.putBoolean(IS_LOGGED_IN, true)
        editor.putString(USERNAME, username)

        editor.apply()
    }

    fun isLogged(): Boolean {
        return preferences.getBoolean(IS_LOGGED_IN, false)
    }

    fun closeSession() {
        preferences.edit().clear().apply()
    }

}