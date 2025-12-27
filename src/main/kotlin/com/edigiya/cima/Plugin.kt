package com.edigiya.cima

import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class Plugin {
    fun load() {
        registerMainAPI(CimaProvider())
    }
}
