package com.mehmetpetek.basicimagelutfilter.features.navigation

import android.net.Uri
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.composable
import com.mehmetpetek.basicimagelutfilter.features.screen.filter.FilterScreenRoute

const val filterNavigationRoute = "filter_route"
const val filterImagePathArg = "filter_image_path_arg"

internal class FilterImageDetailArgs(val filterImage: String) {
    constructor(savedStateHandle: SavedStateHandle) :
            this(filterImage = checkNotNull(Uri.decode(savedStateHandle[filterImagePathArg])))
}

fun NavController.navigateToFilter(filterImageDetail: String, navOptions: NavOptions? = null) {
    val filterImagePathArg = Uri.encode(filterImageDetail)
    this.navigate(filterNavigationRoute.plus("/$filterImagePathArg"), navOptions)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.filterScreen() {
    composable(route = filterNavigationRoute.plus("/{$filterImagePathArg}"),
        arguments = listOf(
            navArgument(filterImagePathArg) { type = NavType.StringType }
        )) {
        FilterScreenRoute()
    }
}