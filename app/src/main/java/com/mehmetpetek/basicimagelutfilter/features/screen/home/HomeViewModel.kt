package com.mehmetpetek.basicimagelutfilter.features.screen.home

import com.mehmetpetek.basicimagelutfilter.features.base.BaseViewModel
import com.mehmetpetek.basicimagelutfilter.features.base.IEffect
import com.mehmetpetek.basicimagelutfilter.features.base.IEvent
import com.mehmetpetek.basicimagelutfilter.features.base.IState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
) : BaseViewModel<HomeState, HomeEvent, HomeEffect>() {

    override fun setInitialState() = HomeState()

    override fun handleEvents(event: HomeEvent) {
        when (event) {
            else -> Unit
        }
    }
}


data class HomeState(
    val isLoading: Boolean = true,
) : IState

sealed interface HomeEffect : IEffect {
    data class ShowError(val message: String) : HomeEffect
}

sealed interface HomeEvent : IEvent