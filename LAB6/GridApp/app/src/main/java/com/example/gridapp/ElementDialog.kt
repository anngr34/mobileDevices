package com.example.gridapp

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class ElementDialog : DialogFragment() {

    private var valueInElement: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        valueInElement = arguments?.getInt("value") as Int
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireActivity())
            .setTitle("Number")
            .setMessage("You choose number: $valueInElement")
            .setPositiveButton("Ok", null)
            .create()
    }

    companion object {
        fun newInstance(valueInElement: Int): ElementDialog {
            val args = Bundle()
            args.putInt("value", valueInElement)
            val fragment = ElementDialog()
            fragment.arguments = args
            return fragment
        }
    }
}