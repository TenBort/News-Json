package com.example.test1.data.SharedPreferences

import android.content.SharedPreferences

class Preferences(private val preferences: SharedPreferences) {

    fun getUserName(): String? {
        return preferences.getString(USER_NAME, "")
    }

    fun saveUserName(userName: String) {
        preferences.edit().putString(USER_NAME, userName).apply()
    }

    companion object {
        private const val USER_NAME = "user_name"
    }
}

