package com.galacticware.griddle.domain.design.base.collection

import com.galacticware.griddle.domain.design.base.button.IButtonBuilder

open class ButtonBuilders(
    vararg buttonBuilders0: IButtonBuilder,
): IButtonBuilderSet {
    val buttonBuilders:MutableSet<IButtonBuilder> = buttonBuilders0.map { it }.toMutableSet()

    fun plus(vararg builders: IButtonBuilder) = this.also { addAll(builders) }
    fun plus(collection: Collection<IButtonBuilder>) = this.also { addAll(collection) }
    fun minus(vararg builders: IButtonBuilder) = this.also { removeAll(builders) }
    fun minus(collection: Collection<IButtonBuilder>) = this.also { removeAll(collection) }

    override val logicalButtonGrouping: LogicalButtonGrouping get() = LogicalButtonGrouping(*buttonBuilders.toTypedArray())

    override val size: Int get() = buttonBuilders.size

    override fun contains(element: IButtonBuilder): Boolean = buttonBuilders.contains(element)

    override fun containsAll(elements: Collection<IButtonBuilder>): Boolean = buttonBuilders.containsAll(elements)

    override fun isEmpty(): Boolean = buttonBuilders.isEmpty()

    override fun add(element: IButtonBuilder): Boolean = buttonBuilders.add(element)

    override fun addAll(elements: Collection<IButtonBuilder>): Boolean = buttonBuilders.addAll(elements)

    override fun clear() = buttonBuilders.clear()

    override fun iterator(): MutableIterator<IButtonBuilder> = buttonBuilders.iterator()

    override fun remove(element: IButtonBuilder): Boolean = buttonBuilders.remove(element)

    override fun removeAll(elements: Collection<IButtonBuilder>): Boolean = buttonBuilders.removeAll(elements)

    override fun retainAll(elements: Collection<IButtonBuilder>): Boolean = buttonBuilders.retainAll(elements)
}
