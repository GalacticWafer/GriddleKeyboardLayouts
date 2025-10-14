package com.galacticware.griddle.domain.design.base.collection

import com.galacticware.griddle.domain.design.base.button.IButtonBuilder

interface IButtonBuilderSet: MutableSet<IButtonBuilder> {
    companion object {
        fun Collection<IButtonBuilder>.toButtonBuilders() =
            ButtonBuilders(*toTypedArray())
    }
    val logicalButtonGrouping: LogicalButtonGrouping
}