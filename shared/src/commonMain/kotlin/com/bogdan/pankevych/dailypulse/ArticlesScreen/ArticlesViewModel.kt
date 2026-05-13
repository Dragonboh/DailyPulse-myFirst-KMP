package com.bogdan.pankevych.dailypulse.ArticlesScreen

import com.bogdan.pankevych.dailypulse.BaseViewModel
//import kotlinx.coroutines.delay
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.launch
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class ArticlesViewModel: BaseViewModel() {
    private val _articlesStateFlow = MutableStateFlow(ArticlesState(loading = true))

    val articlesStateFlow: StateFlow<ArticlesState>
        get() = _articlesStateFlow

    init {
        getArticles()
    }

    private fun getArticles() {
        val mockArticles = listOf(
            Article(
                title = "Stock market today: Live updates - CNBC",
                description = "Futures were higher in premarket trading as Wall Street tried to regain its footing.",
                date = "2023-11-09",
                imageURL = "https://image.cnbcfm.com/api/v1/image/107326078-1698758530118-gettyimages-1765623456-wall26362_igj6ehhp.jpg"
            ),
            Article(
                title = "Best iPhone Deals (2023): Carrier Deals, Unlocked iPhones",
                description = "Apple's smartphones rarely go on sale, but if you’re looking to upgrade (or you’re gift shopping), here are a...",
                date = "2023-11-09",
                imageURL = "https://media.wired.com/photos/622aa5c8cca6acf55fb70b57/191:100/w_1280,c_limit/iPhone-13-Pro-Colors-SOURCE.jpg"
            ),
            Article(
                title = "Samsung details ‘Galaxy AI’ and a feature that can translate phone calls in real time",
                description = "In a new blog post, Samsung previewed what it calls “a new era of Galaxy AI” coming to its smartphones and devices...",
                date = "2023-11-09",
                imageURL = ""
            )
        )

        scope.launch {
            delay(1500)
            _articlesStateFlow.emit(ArticlesState(error = "WRONG WRONG"))

            delay(1500)
            _articlesStateFlow.emit(ArticlesState(articles = mockArticles))
        }
    }
}
