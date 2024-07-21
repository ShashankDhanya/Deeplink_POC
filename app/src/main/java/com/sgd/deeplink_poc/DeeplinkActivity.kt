package com.sgd.deeplink_poc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.deeplinkdispatch.DeepLinkHandler

private const val TAG = "DeeplinkActivity"

@DeepLinkHandler(AppDeepLinkModule::class)
class DeeplinkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val deepLinkDelegate = DeepLinkDelegate(AppDeepLinkModuleRegistry())
        deepLinkDelegate.dispatchFrom(this)
        finish()
        // Do something with idString
    }
}