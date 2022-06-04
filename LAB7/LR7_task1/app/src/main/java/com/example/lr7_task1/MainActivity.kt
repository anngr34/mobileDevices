package com.example.lr7_task1

import android.Manifest
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.lr7_task1.receiver.AirplaneModeStateReceiver
import com.example.lr7_task1.receiver.CameraButtonClickReceiver
import com.example.lr7_task1.receiver.BatteryStateReceiver


class MainActivity : AppCompatActivity() {

    private val batteryStateReceiver = BatteryStateReceiver()
    private val cameraButtonClickReceiver = CameraButtonClickReceiver()
    private val airplaneModeStateReceiver = AirplaneModeStateReceiver()

    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            Log.d(MainActivity::class.simpleName, "Permission result: $it")
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        val batteryStateFilter = IntentFilter(Intent.ACTION_BATTERY_LOW)
        val cameraButtonClickFilter = IntentFilter(Intent.ACTION_CAMERA_BUTTON)
        val airplaneModeStateFilter = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)

        registerReceiver(batteryStateReceiver,batteryStateFilter)
        registerReceiver(cameraButtonClickReceiver, cameraButtonClickFilter)
        registerReceiver(airplaneModeStateReceiver, airplaneModeStateFilter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(batteryStateReceiver)
        unregisterReceiver(cameraButtonClickReceiver)
        unregisterReceiver(airplaneModeStateReceiver)
    }

    override fun onResume() {
        super.onResume()
        requestPermissionLauncher.launch(Manifest.permission.CAMERA)
    }
}