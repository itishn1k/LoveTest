package com.example.lovetest.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.lovetest.App
import com.example.lovetest.R
import com.example.lovetest.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            btnCalculate.setOnClickListener {
                    viewModel.getLiveLove(etFirst.text.toString(), etSecond.text.toString())
                        .observe(viewLifecycleOwner) {
                            App.appDatabase.loveDao().insert(it)
                            val bundle = Bundle()
                            bundle.putSerializable("response", it)
                            findNavController().navigate(R.id.navigation_result, bundle)
                        }
            }
            btnHistory.setOnClickListener {
                findNavController().navigate(R.id.navigation_history)
            }
        }
    }

}