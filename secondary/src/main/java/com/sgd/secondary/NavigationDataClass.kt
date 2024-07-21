package com.sgd.secondary

import com.airbnb.deeplinkdispatch.handler.DeepLinkParamType
import com.airbnb.deeplinkdispatch.handler.DeeplinkParam

data class NavigationData(
    @DeeplinkParam("name", DeepLinkParamType.Path) val name: String,
    @DeeplinkParam("query", DeepLinkParamType.Query) val query: String?,
){
    override fun toString(): String {
        return "name: $name, query: $query"
    }
}