package com.galacticware.griddle.domain.design.base.gesture

import com.galacticware.griddle.domain.util.feedback.GriddleInitializable
import com.galacticware.griddle.domain.viewmodel.byok.KeyboardViewModel

abstract class ViewModelUser {
    companion object: GriddleInitializable<KeyboardViewModel> {
        override fun initialize(viewModel: KeyboardViewModel) {
            vm0 = { viewModel }
        }
        private lateinit var vm0: () -> KeyboardViewModel
        fun vm() = vm0()
    }
}