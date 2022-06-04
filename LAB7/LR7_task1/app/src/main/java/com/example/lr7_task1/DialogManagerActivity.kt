package com.example.lr7_task1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.example.lr7_task1.dialog.AirplaneModeStateDialog
import com.example.lr7_task1.dialog.BatteryStateDialog
import com.example.lr7_task1.dialog.CameraButtonClickDialog

class DialogManagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)
        val id = intent.getIntExtra("dialog_type", 0)
        val dialog: DialogFragment
        when (id) {
            1 -> {
                dialog = BatteryStateDialog()
                dialog.show(supportFragmentManager, "BatteryStateDialog")
            }
            2 -> {
                dialog = CameraButtonClickDialog()
                dialog.show(supportFragmentManager, "CameraButtonClickDialog")
            }
            3 -> {
                dialog = AirplaneModeStateDialog()
                dialog.show(supportFragmentManager, "AirplaneModeStateDialog")
            }
        }
    }
}