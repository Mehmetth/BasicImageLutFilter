package com.mehmetpetek.basicimagelutfilter.features.screen.filter

import com.mehmetpetek.basicimagelutfilter.features.base.BaseViewModel
import com.mehmetpetek.basicimagelutfilter.features.base.IEffect
import com.mehmetpetek.basicimagelutfilter.features.base.IEvent
import com.mehmetpetek.basicimagelutfilter.features.base.IState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FilterViewModel @Inject constructor(
) : BaseViewModel<FilterState, FilterEvent, FilterEffect>() {

    override fun setInitialState() = FilterState()

    override fun handleEvents(event: FilterEvent) {
        when (event) {
            else -> Unit
        }
    }
}


data class FilterState(
    val isLoading: Boolean = true,
) : IState

sealed interface FilterEffect : IEffect {
    data class ShowError(val message: String) : FilterEffect
}

sealed interface FilterEvent : IEvent