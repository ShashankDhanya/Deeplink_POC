package com.sgd.secondary

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.airbnb.deeplinkdispatch.DeepLink
import com.sgd.secondary.databinding.ActivityThirdBinding

private const val TAG = "ThirdActivity"

class ThirdActivity : AppCompatActivity() {

    private val binding: ActivityThirdBinding by lazy { ActivityThirdBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        Log.d(TAG, "onCreate: ${intent.getBooleanExtra(DeepLink.IS_DEEP_LINK, false)}")
        val name = intent.getStringExtra("name")
        binding.textView.text = "$TAG: $name"
    }
}