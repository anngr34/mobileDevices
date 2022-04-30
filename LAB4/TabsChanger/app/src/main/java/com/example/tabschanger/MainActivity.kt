package com.example.tabschanger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.tabschanger.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.setOnItemSelectedListener {
            val fragment: Fragment
            when (it.itemId) {
                R.id.item_island -> {
                    fragment = IslandFragment.newInstance()
                    setCurrentFragment(fragment)
                }
                R.id.item_mountain -> {
                    fragment = MountainFragment.newInstance()
                    setCurrentFragment(fragment)
                }
                R.id.item_house -> {
                    fragment = HouseFragment.newInstance()
                    setCurrentFragment(fragment)
                }
            }
            true
        }
        binding.bottomNavigationView.selectedItemId = R.id.item_house
    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.commit {
            replace(R.id.fragmentContainerView, fragment)
        }
    }
}