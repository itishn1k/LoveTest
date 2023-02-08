package com.example.lovetest.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.lovetest.remote.LoveModel
import com.example.lovetest.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    fun getLiveLove(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getLove(firstName, secondName)
    }
}