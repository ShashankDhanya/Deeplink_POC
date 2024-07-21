package com.sgd.deeplink_poc

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.deeplinkdispatch.DeepLink
import com.sgd.deeplink_poc.databinding.ActivityMainBinding

private const val TAG = "SecondActivity"

class SecondActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        Log.d(TAG, "onCreate: ${intent.getBooleanExtra(DeepLink.IS_DEEP_LINK, false)}")
        val name = intent.getStringExtra("name")
        binding.textView.text = "$TAG: $name"
    }
}