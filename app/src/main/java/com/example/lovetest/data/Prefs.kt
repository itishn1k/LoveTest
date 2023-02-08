package com.example.lovetest.data

import android.content.Context
import android.content.Context.MODE_PRIVATE

class Prefs(context: Context) {

    private val prefs = context.getSharedPreferences(PREF_NAME, MODE_PRIVATE)

    //onboard
    fun setOnBoardingSeen() {
        prefs.edit().putBoolean(ON_BOARDING_SEEN, true).apply()
    }

    fun isOnBoardingSeen(): Boolean {
        return prefs.getBoolean(ON_BOARDING_SEEN, false)
    }

    companion object {
        private const val ON_BOARDING_SEEN = "is_seen"
        private const val PREF_NAME = "love"
    }
}
