package com.bogdan.pankevych.dailypulse

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppScaffold() {
    val navController = rememberNavController()

    Scaffold {
        AppNavHost(
            navController = navController,
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
        )
    }
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screens.ArticlesScreen.route,
        modifier = modifier,
    ) {
        composable(Screens.ArticlesScreen.route) {
            ArticlesScreen(
                articlesViewModel = ArticlesViewModel(),
                onAboutButtonClick = { navController.navigate(Screens.AboutScreen.route) },
            )
        }

        composable(Screens.AboutScreen.route) {
            AboutScreen(
                closeButtonClick = { navController.popBackStack() }
            )
        }
    }
}
