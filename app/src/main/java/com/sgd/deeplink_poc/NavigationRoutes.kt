package com.sgd.deeplink_poc

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.core.app.TaskStackBuilder
import com.airbnb.deeplinkdispatch.handler.DeepLinkHandler
import com.sgd.deeplink_poc.annotations.AppDeepLink
import com.sgd.deeplink_poc.annotations.WebDeepLink
import com.sgd.secondary.ForthActivity
import com.sgd.secondary.NavigationData
import com.sgd.secondary.ThirdActivity

private const val TAG = "NavigationRoutes"

object NavigationRoutes {
    @AppDeepLink("/{name}")
    @JvmStatic
    fun handleDeeplinkIntent(context: Context): Intent {
        return Intent(context, MainActivity::class.java)
    }

    @AppDeepLink("/dp/{name}?query={data}")
    object Queryhandler : DeepLinkHandler<NavigationData> {
        override fun handleDeepLink(context: Context, deepLinkArgs: NavigationData) {
            Log.d(TAG, "handleDeepLink: $deepLinkArgs")
            TaskStackBuilder.create(context)
                .addParentStack(MainActivity::class.java)
                .addNextIntentWithParentStack(Intent(context, MainActivity::class.java))
                .addNextIntent(Intent(context, ForthActivity::class.java).apply {
                    putExtras(Bundle().apply { putString("data", deepLinkArgs.toString()) })
                })
                .startActivities()
        }
    }

    @WebDeepLink("/{name}")
    @JvmStatic
    fun handleDeeplinkIntentHttps(context: Context): TaskStackBuilder {
        return TaskStackBuilder.create(context)
            .addParentStack(MainActivity::class.java)
            .addNextIntentWithParentStack(Intent(context, MainActivity::class.java))
            .addNextIntent(Intent(context, ThirdActivity::class.java))
    }

    @WebDeepLink("/dp/{name}")
    @JvmStatic
    fun handleDeeplinkIntentHttp(context: Context): TaskStackBuilder {
        return TaskStackBuilder.create(context)
            .addParentStack(MainActivity::class.java)
            .addNextIntentWithParentStack(Intent(context, MainActivity::class.java))
            .addNextIntent(Intent(context, SecondActivity::class.java))
    }
}