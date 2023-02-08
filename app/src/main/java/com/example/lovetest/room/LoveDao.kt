package com.example.lovetest.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.lovetest.remote.LoveModel

@Dao
interface LoveDao {
    @Query("SELECT * FROM 'love_table' ORDER BY firstName ASC")
    fun getAll(): List<LoveModel>

    @Insert
    fun insert(loveModel: LoveModel)

    @Delete
    fun delete(loveModel: LoveModel)

    @Update
    fun update(loveModel: LoveModel)
}