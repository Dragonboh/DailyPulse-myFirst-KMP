package com.bogdan.pankevych.dailypulse

//import com.bogdan.pankevych.dailypulse.ArticleRaw
import com.bogdan.pankevych.dailypulse.ArticlesResponse
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.*
import io.ktor.client.statement.bodyAsText
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class ArticlesService() {

    private val country = "us"
    private val category = "business"
    private val apiKey = "f67ace1b27b24ce4b95c7f71fde88920"

    suspend fun fetchArticles(): List<ArticleRaw> {

//        val httpClient = HttpClient {
//            install(ContentNegotiation) {
//                json(json {
//                    prettyPrint = true
//                    isLenient = true
//                    ignoreUnknownKeys = true
//                })
//            }
//        }

//        val service = ArticlesService(httpClient)
//
//        useCase = ArticlesUseCase(service)

        val client =  HttpClient {
            install(plugin = ContentNegotiation) {
                json()
            }
        }
        val response = client.get("https://newsapi.org/v2/top-headlines?country=$country&category=$category&apiKey=$apiKey")


//        val response = client.get(url)

        val rawJson: String = response.bodyAsText()

        val json = Json {
            ignoreUnknownKeys = true
        }
        val articlesResponse: ArticlesResponse = json.decodeFromString<ArticlesResponse>(rawJson)

//        println(articlesResponse)
//        println(response.status)
//        println(response.headers["Content-Type"])
//        val articles: ArticlesResponse = response.body()
//        println(response.bodyAsText())
//        val response: ArticlesResponse = client.get("https://newsapi.org/v2/top-headlines?country=$country&category=$category&apiKey=$apiKey").body()
//        println(response)
//        return response.articles

        return articlesResponse.articles.toList()
    }
}

