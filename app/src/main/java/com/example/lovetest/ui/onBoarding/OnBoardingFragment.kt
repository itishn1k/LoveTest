package com.example.lovetest.ui.onBoarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lovetest.R
import com.example.lovetest.data.Prefs
import com.example.lovetest.databinding.FragmentOnBoardingBinding
import dagger.hilt.android.AndroidEntryPoint
import me.relex.circleindicator.CircleIndicator3
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardingFragment
/*@Inject constructor(var prefs: Prefs)*/ : Fragment() {
    private lateinit var binding: FragmentOnBoardingBinding

    @Inject
     lateinit var prefs: Prefs

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = OnBoardingAdapter(requireContext(), this::onClick)
//        prefs = Prefs(requireContext())
        binding.viewPager.adapter = adapter
        attachIndicator()
    }

    private fun onClick() {
        prefs.setOnBoardingSeen()
        findNavController().navigate(R.id.navigation_home)
    }

    //circle indicator
    private fun attachIndicator() {
        val indicator: CircleIndicator3 = binding.indicator
        val viewpager = binding.viewPager
        indicator.setViewPager(viewpager)
    }

}