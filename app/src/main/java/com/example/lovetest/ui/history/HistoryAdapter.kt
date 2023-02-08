package com.example.lovetest.ui.history

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lovetest.databinding.ItemHistoryBinding
import com.example.lovetest.remote.LoveModel

class HistoryAdapter : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {
    private val data: ArrayList<LoveModel> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(
            ItemHistoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addData(newData: List<LoveModel>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = data.size


    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class HistoryViewHolder(private val binding: ItemHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(loveModel: LoveModel) {
            binding.person1.text = loveModel.firstName
            binding.person2.text = loveModel.secondName
            binding.percentHistory.text = loveModel.percentage
            binding.result.text = loveModel.result
        }
    }
}