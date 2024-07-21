package com.sgd.deeplink_poc

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.airbnb.deeplinkdispatch.DeepLink
import com.sgd.deeplink_poc.annotations.AppDeepLink
import com.sgd.deeplink_poc.annotations.WebDeepLink
import com.sgd.deeplink_poc.databinding.ActivityMainBinding

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

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

