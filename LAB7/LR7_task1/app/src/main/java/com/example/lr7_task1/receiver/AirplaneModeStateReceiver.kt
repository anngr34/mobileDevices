package com.example.lr7_task1.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.lr7_task1.DialogManagerActivity

class AirplaneModeStateReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_AIRPLANE_MODE_CHANGED) {
            val i = Intent(context, DialogManagerActivity::class.java)
            i.putExtra("dialog_type", 3)
            context?.startActivity(i)
        }
    }
}
