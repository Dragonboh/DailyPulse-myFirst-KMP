package com.bogdan.pankevych.dailypulse

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.*
import com.bogdan.pankevych.dailypulse.ArticlesScreen.*
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.style.*
import coil.compose.AsyncImage


@Composable
fun ArticlesScreen(
    articlesViewModel: ArticlesViewModel,
) {
    val articlesState = articlesViewModel.articlesStateFlow.collectAsState()

    Column {
        AppBar()

        if (articlesState.value.loading)
            Loader()

        if (articlesState.value.error != null)
            ErrorMessage(articlesState.value.error!!)

        if (articlesState.value.articles.isNotEmpty())
            ArticlesListView(
                articlesViewModel.articlesStateFlow.collectAsState().value.articles
            )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppBar() {
    TopAppBar(
        title = { Text(text = "Articles") },
    )
}

@Composable
fun Loader() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.width(64.dp),
            color = MaterialTheme.colorScheme.surfaceVariant,
            trackColor = MaterialTheme.colorScheme.secondary,
        )
    }
}


@Composable
fun ArticlesListView(articles: List<Article>) {

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(articles) { article ->
            ArticleItemView(article = article)
        }
    }
}


@Composable
fun ArticleItemView(article: Article) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        AsyncImage(
            model = article.imageURL,
            contentDescription = null
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = article.title,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = article.description)

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = article.date,
            style = TextStyle(color = Color.Gray),
            modifier = Modifier.align(Alignment.End)
        )

        Spacer(modifier = Modifier.height(4.dp))
    }
}

@Composable
fun ErrorMessage(message: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = message,
            style = TextStyle(
                fontSize = 28.sp,
                textAlign = TextAlign.Center
            )
        )
    }
}


