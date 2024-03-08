package com.mehmetpetek.basicimagelutfilter.features.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.mehmetpetek.basicimagelutfilter.common.toJson

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavGraph() {
    val navController = rememberAnimatedNavController()

    AnimatedNavHost(
        navController = navController,
        startDestination = homeNavigationRoute,
    ) {
        homeScreen(navigateToFilter = {
            navController.navigateToFilter(it.toJson())
        })
        filterScreen()
    }
}