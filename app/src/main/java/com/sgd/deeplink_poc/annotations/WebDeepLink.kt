package com.sgd.deeplink_poc.annotations

import com.airbnb.deeplinkdispatch.DeepLinkSpec

@DeepLinkSpec(prefix = ["http://deeplink", "https://deeplink"])
@Retention(AnnotationRetention.RUNTIME)
annotation class WebDeepLink(vararg val value: String)