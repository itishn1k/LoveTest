package com.example.lovetest.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lovetest.App
import com.example.lovetest.databinding.FragmentHistoryBinding
import com.example.lovetest.remote.LoveModel

class HistoryFragment : Fragment() {

    private lateinit var binding: FragmentHistoryBinding
    private lateinit var adapter: HistoryAdapter
    private lateinit var data: List<LoveModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = HistoryAdapter()
        binding.rvHistory.adapter = adapter
        setData()
    }

    private fun setData() {
        data = App.appDatabase.loveDao().getAll()
        adapter.addData(data)
    }
}