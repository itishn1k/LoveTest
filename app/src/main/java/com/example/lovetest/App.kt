package com.example.lovetest

import android.annotation.SuppressLint
import android.app.Application
import androidx.room.Room
import com.example.lovetest.room.AppDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        appDatabase = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "love_data"
        ).allowMainThreadQueries().build()
    }

    companion object {
        lateinit var appDatabase: AppDatabase
    }

}