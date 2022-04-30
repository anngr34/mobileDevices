package com.example.imagetaker

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.core.content.FileProvider
import androidx.lifecycle.lifecycleScope
import java.io.File
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.takephotoapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private var latestTmpUri: Uri? = null
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setClickListeners()
    }

    private fun setClickListeners() {
        binding.takeImageButton.setOnClickListener { takePhoto() }
        binding.sendPhotoButton.setOnClickListener {
            val i = Intent(Intent.ACTION_SEND)
            i.type = "text/plain"
            i.putExtra(Intent.EXTRA_SUBJECT, "КПП НАІ-196 Резвіна")
            i.putExtra(Intent.EXTRA_STREAM, latestTmpUri)
            startActivity(i)
        }
    }

    private val takeAShotLauncher =
        registerForActivityResult(ActivityResultContracts.TakePicture()) { isSuccess ->
            if (isSuccess) {
                latestTmpUri?.let { uri ->
                    binding.imagePreview.setImageURI(uri)
                }
            }
        }

    private fun takePhoto() {
        lifecycleScope.launchWhenStarted {
            getFileUri().let { uri ->
                latestTmpUri = uri
                takeAShotLauncher.launch(uri)
            }
        }
    }

    private fun getFileUri(): Uri {
        val tmpFile = File.createTempFile("Rezvina_selfie", ".png", cacheDir).apply {
            createNewFile()
            deleteOnExit()
        }
        return FileProvider.getUriForFile(applicationContext,
            "${BuildConfig.APPLICATION_ID}.provider",
            tmpFile)
    }
}