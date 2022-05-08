package com.example.gridapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.gridapp.databinding.ActivityMainBinding

import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    data class Element(val value: Int, val color: Int)

    private val listOfElements: MutableList<Element> = mutableListOf()
    private lateinit var adapter: ElementsRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ElementsRecyclerAdapter(layoutInflater) {
            val dialog = ElementDialog.newInstance(it.value)
            dialog.show(supportFragmentManager, "dialog")
        }

        binding.listElements.adapter = adapter
        binding.listElements.layoutManager = GridLayoutManager(this, 4)
        adapter.submitList(null)
        for (i in 1..32) {
            val value = Random.nextInt(1, 99)
            val color =
                Color.argb(255, Random.nextInt(256), Random.nextInt(256), Random.nextInt(256));
            listOfElements.add(Element(value, color))
        }
        adapter.submitList(listOfElements.toList())

    }

    override fun onStart() {
        super.onStart()
        adapter.submitList(listOfElements.toList())
    }
}