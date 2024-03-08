package com.mehmetpetek.basicimagelutfilter.features.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun HomeScreenRoute(
    viewModel: HomeViewModel = hiltViewModel(),
    navigateToFilter: (String) -> Unit
) {
    val viewState = viewModel.state.collectAsState().value

    LaunchedEffect(viewModel.effect) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is HomeEffect.ShowError -> Unit
            }
        }
    }

    HomeScreen(
        viewState,
        onViewEvent = viewModel::setEvent
    )
}

@Composable
private fun HomeScreen(
    viewState: HomeState,
    onViewEvent: (HomeEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Blue)
    ) {
        Text(text = "Home Screen", Modifier.align(Alignment.Center))
    }
}