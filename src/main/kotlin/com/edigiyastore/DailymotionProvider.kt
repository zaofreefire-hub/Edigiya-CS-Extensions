package com.edigiyastore

import com.lagradost.cloudstream3.*

class DailymotionProvider : MainAPI() {

    override var mainUrl = "https://www.dailymotion.com"
    override var name = "Dailymotion Arabic - Edigiya Store"
    override val lang = "ar"
    override val supportedTypes = setOf(TvType.Movie)

    override suspend fun search(query: String): List<SearchResponse>? {
        return listOf(
            MovieSearchResponse(
                name = "Dailymotion Sample Result",
                url = "$mainUrl/video/x7tgczr",
                apiName = name,
                type = TvType.Movie,
                posterUrl = "https://s1.dmcdn.net/v/SAMPLE"
            )
        )
    }

    override suspend fun load(url: String): LoadResponse? {
        return MovieLoadResponse(
            name = "Dailymotion Video",
            url = url,
            dataUrl = url,
            posterUrl = "",
            plot = "Video from Dailymotion (Edigiya Store)",
            recommendations = listOf()
        )
    }

    override suspend fun loadLinks(
        data: String,
        isCasting: Boolean,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit
    ): Boolean {

        callback(
            ExtractorLink(
                source = name,
                name = "Dailymotion Player",
                url = data,
                referer = mainUrl,
                quality = Qualities.Unknown.value,
                isM3u8 = false
            )
        )

        return true
    }
}
