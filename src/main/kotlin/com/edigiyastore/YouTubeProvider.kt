package com.edigiyastore

import com.lagradost.cloudstream3.*

class YouTubeProvider : MainAPI() {

    override var mainUrl = "https://www.youtube.com"
    override var name = "YouTube Arabic - Edigiya Store"
    override val lang = "ar"
    override val supportedTypes = setOf(TvType.Movie)

    override suspend fun search(query: String): List<SearchResponse>? {
        return listOf(
            MovieSearchResponse(
                name = "YouTube Search Result",
                url = "$mainUrl/watch?v=dQw4w9WgXcQ",
                apiName = name,
                type = TvType.Movie,
                posterUrl = "https://img.youtube.com/vi/dQw4w9WgXcQ/hqdefault.jpg"
            )
        )
    }

    override suspend fun load(url: String): LoadResponse? {
        val id = url.substringAfter("v=")
        return MovieLoadResponse(
            name = "YouTube Video",
            url = url,
            dataUrl = id,
            posterUrl = "https://img.youtube.com/vi/$id/maxresdefault.jpg",
            plot = "YouTube Video via Edigiya Store",
            recommendations = listOf()
        )
    }

    override suspend fun loadLinks(
        data: String,
        isCasting: Boolean,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit
    ): Boolean {

        val embed = "https://www.youtube.com/embed/$data"

        callback.invoke(
            ExtractorLink(
                source = name,
                name = "YouTube Embed",
                url = embed,
                referer = mainUrl,
                quality = Qualities.Unknown.value,
                isM3u8 = false
            )
        )

        return true
    }
}
