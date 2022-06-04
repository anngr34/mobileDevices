package com.example.lr7_task1.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.lr7_task1.DialogManagerActivity

class CameraButtonClickReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_CAMERA_BUTTON) {
            val i = Intent(context, DialogManagerActivity::class.java)
            i.putExtra("dialog_type", 2)
            context?.startActivity(i)
        }
    }
}
