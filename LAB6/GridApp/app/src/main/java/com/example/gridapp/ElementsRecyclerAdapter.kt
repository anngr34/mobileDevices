package com.example.gridapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView

class ElementsRecyclerAdapter(
    private val inflater: LayoutInflater,
    private val onClick: (MainActivity.Element) -> Unit,
) :
    ListAdapter<MainActivity.Element, ElementsRecyclerAdapter.ViewHolder>(ElementDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.list_item, parent, false)
        return ViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val element = getItem(position)
        holder.bind(element)
    }

    object ElementDiffCallback : DiffUtil.ItemCallback<MainActivity.Element>() {
        override fun areItemsTheSame(
            oldItem: MainActivity.Element,
            newItem: MainActivity.Element,
        ): Boolean {

            val res = oldItem == newItem

            return res
        }

        override fun areContentsTheSame(
            oldItem: MainActivity.Element,
            newItem: MainActivity.Element,
        ): Boolean {
            val res = oldItem.value == newItem.value && oldItem.color == newItem.color

            return res
        }
    }

    class ViewHolder(
        view: View,
        val onClick: (MainActivity.Element) -> Unit,
    ) : RecyclerView.ViewHolder(view) {
        private val value = view.findViewById<TextView>(R.id.valueIn)
        private val circleElement = view.findViewById<MaterialCardView>(R.id.circle_element)
        private var element: MainActivity.Element? = null

        init {
            view.setOnClickListener {
                element?.let {
                    onClick(it)
                }
            }
        }

        fun bind(element: MainActivity.Element) {
            this.element = element
            value.text = element.value.toString()
            circleElement.setCardBackgroundColor(element.color)
        }
    }
}