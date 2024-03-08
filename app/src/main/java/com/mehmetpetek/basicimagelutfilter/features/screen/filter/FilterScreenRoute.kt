package com.mehmetpetek.basicimagelutfilter.features.screen.filter

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
fun FilterScreenRoute(
    viewModel: FilterViewModel = hiltViewModel()
) {
    val viewState = viewModel.state.collectAsState().value

    LaunchedEffect(viewModel.effect) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is FilterEffect.ShowError -> Unit
            }
        }
    }

    FilterScreen(
        viewState,
        onViewEvent = viewModel::setEvent
    )
}

@Composable
private fun FilterScreen(
    viewState: FilterState,
    onViewEvent: (FilterEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Text(text = "Filter Screen", Modifier.align(Alignment.Center))
    }
}