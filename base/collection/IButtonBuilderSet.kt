package com.galacticwarev2.griddle.domain.design.base.collection

import com.galacticwarev2.griddle.domain.design.base.button.IButtonBuilder

interface IButtonBuilderSet: MutableSet<IButtonBuilder> {
    companion object {
        fun Collection<IButtonBuilder>.toButtonBuilders() =
            ButtonBuilders(*toTypedArray())
    }
    val logicalButtonGrouping: LogicalButtonGrouping
}