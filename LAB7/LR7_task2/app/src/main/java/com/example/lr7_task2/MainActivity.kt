package com.example.lr7_task2

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

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

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val batteryInfoChannel =
                NotificationChannel("1", "Battery state", NotificationManager.IMPORTANCE_LOW)
            val airplaneModeChannel =
                NotificationChannel(
                    "2",
                    "Camera button clicked",
                    NotificationManager.IMPORTANCE_HIGH
                )
            val cameraButtonChannel =
                NotificationChannel("3", "Airplane mode state", NotificationManager.IMPORTANCE_HIGH)

            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

            notificationManager.createNotificationChannel(batteryInfoChannel)
            notificationManager.createNotificationChannel(airplaneModeChannel)
            notificationManager.createNotificationChannel(cameraButtonChannel)

        }
    }

    override fun onStart() {
        super.onStart()
        val batteryStateFilter = IntentFilter(Intent.ACTION_BATTERY_LOW)
        val cameraButtonClickFilter = IntentFilter(Intent.ACTION_CAMERA_BUTTON)
        val airplaneModeStateFilter = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)

        registerReceiver(batteryStateReceiver, batteryStateFilter)
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