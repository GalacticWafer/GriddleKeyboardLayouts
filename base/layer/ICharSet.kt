package com.galacticwarev2.griddle.domain.design.base.layer

import com.galacticwarev2.griddle.domain.util.toPascalCase

interface ICharSet {
    val name: String get() = this::class.simpleName?.toPascalCase()?: ""
}