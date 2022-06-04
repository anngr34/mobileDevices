package com.example.lr7_task1.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.lr7_task1.DialogManagerActivity

class BatteryStateReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_BATTERY_LOW) {
            val i = Intent(context, DialogManagerActivity::class.java)
            i.putExtra("dialog_type", 1)
            context?.startActivity(i)
        }
    }

}
