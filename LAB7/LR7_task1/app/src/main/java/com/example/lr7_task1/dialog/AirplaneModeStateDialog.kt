package com.example.lr7_task1.dialog

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.lr7_task1.MainActivity

class AirplaneModeStateDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): AlertDialog {
        return AlertDialog.Builder(requireActivity())
            .setTitle("Airplane mode state")
            .setMessage(
                if (Settings.System.getInt(
                        context?.contentResolver,
                        Settings.Global.AIRPLANE_MODE_ON,
                        0
                    ) != 0
                ) "Airplane mode is ON" else "Airplane mode is OFF"
            )
            .setPositiveButton("Got it!", DialogInterface.OnClickListener { _, _ ->
                startActivity(Intent(context, MainActivity::class.java))
            })
            .create()

    }
}
