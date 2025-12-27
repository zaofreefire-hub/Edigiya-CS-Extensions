package com.cimaprovider

import com.lagradost.cloudstream3.*
import com.lagradost.cloudstream3.LoadResponse.Companion.addTrailer

class CimaProvider : MainAPI() {

    override var mainUrl = "https://example.com"
    override var name = "CimaProvider"
    override val supportedTypes = setOf(TvType.Movie)

    override suspend fun search(query: String): List<SearchResponse> {
        return listOf(
            MovieSearchResponse(
                "نتيجة بحث: $query",
                "$mainUrl/movie/demo",
                TvType.Movie,
                poster = "https://cdn-icons-png.flaticon.com/512/742/742751.png"
            )
        )
    }

    override suspend fun load(url: String): LoadResponse? {
        return newMovieLoadResponse("فيلم تجريبي", url, TvType.Movie) {
            plot = "هذا فيلم تجريبي لعرض كيفية عمل الإضافات."
            posterUrl = "https://cdn-icons-png.flaticon.com/512/742/742751.png"

            addTrailer(
                TrailerData("https://www.youtube.com/watch?v=dQw4w9WgXcQ")
            )

            addSource(
                LinkData(
                    "رابط تشغيل 720p",
                    "https://example.com/video.mp4",
                    true
                )
            )
        }
    }
}
