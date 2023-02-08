package com.example.lovetest.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lovetest.remote.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun loveDao(): LoveDao
}