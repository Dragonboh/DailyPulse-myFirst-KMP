package com.bogdan.pankevych.dailypulse

//import com.bogdan.pankevych.dailypulse.Article
import com.bogdan.pankevych.dailypulse.ArticleRaw
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticlesResponse(
    @SerialName("status")
    val status: String,
    @SerialName("totalResults")
    val results: Int,
    @SerialName("articles")
    val articles: List<ArticleRaw>
)
