package com.example.lr7_task1.dialog


import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.lr7_task1.MainActivity

class BatteryStateDialog() : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireActivity())
            .setTitle("Battery state alert")
            .setMessage("LOW battery")
            .setPositiveButton("Got it!", DialogInterface.OnClickListener {
                    _, _ -> startActivity(Intent(context, MainActivity::class.java))
            })
            .create()
    }
}