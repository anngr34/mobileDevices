package com.example.tabschanger

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tabschanger.databinding.FragmentIslandBinding

class IslandFragment : Fragment(R.layout.fragment_island) {

    private lateinit var binding: FragmentIslandBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentIslandBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    companion object {
        fun newInstance() = IslandFragment()
    }
}