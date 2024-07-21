package com.sgd.deeplink_poc.annotations

import com.airbnb.deeplinkdispatch.DeepLinkSpec

@DeepLinkSpec(prefix = ["deeplink://"])
annotation class AppDeepLink(vararg val value: String)