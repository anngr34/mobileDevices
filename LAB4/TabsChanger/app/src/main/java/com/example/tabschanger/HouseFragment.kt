package com.example.tabschanger

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tabschanger.databinding.FragmentHouseBinding

class HouseFragment : Fragment(R.layout.fragment_house) {

    private lateinit var binding: FragmentHouseBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHouseBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    companion object {
        fun newInstance() = HouseFragment()
    }
}