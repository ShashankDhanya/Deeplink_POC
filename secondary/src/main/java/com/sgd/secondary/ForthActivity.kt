package com.sgd.secondary

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.deeplinkdispatch.DeepLink
import com.sgd.secondary.databinding.ActivityThirdBinding

private const val TAG = "ForthActivity"

class ForthActivity : AppCompatActivity() {
    private val binding: ActivityThirdBinding by lazy { ActivityThirdBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        Log.d(TAG, "onCreate: ${intent.getBooleanExtra(DeepLink.IS_DEEP_LINK, false)}")
        val name = intent.getStringExtra("data")
        binding.textView.text = "$TAG: $name"
    }
}