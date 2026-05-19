package com.bogdan.pankevych.dailypulse

class ArticlesState(
    val articles: List<Article> = listOf(),
    val error: String? = null,
    val loading: Boolean = false
)
