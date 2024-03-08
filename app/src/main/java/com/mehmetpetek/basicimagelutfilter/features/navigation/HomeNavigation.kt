package com.mehmetpetek.basicimagelutfilter.features.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.google.accompanist.navigation.animation.composable
import com.mehmetpetek.basicimagelutfilter.features.screen.home.HomeScreenRoute

const val homeNavigationRoute = "home_route"

fun NavController.navigateToHome(
    navOptions: NavOptions? = null
) {
    this.navigate(homeNavigationRoute, navOptions)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.homeScreen(
    navigateToFilter: (String) -> Unit
) {
    composable(route = homeNavigationRoute) {
        HomeScreenRoute(
            navigateToFilter = navigateToFilter
        )
    }
}