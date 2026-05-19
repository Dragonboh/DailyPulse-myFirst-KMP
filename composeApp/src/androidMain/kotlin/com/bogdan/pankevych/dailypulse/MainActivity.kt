package com.bogdan.pankevych.dailypulse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bogdan.pankevych.dailypulse.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        val vm: ArticlesViewModel by viewModels()
        setContent {
            AppScaffold()
//            App()
//            AboutScreen()
//            ArticlesScreen(articlesViewModel = vm)
        }
    }
}

//@Preview
//@Composable
//fun AppAndroidPreview() {
////    App()
//    AboutScreen()
//}

