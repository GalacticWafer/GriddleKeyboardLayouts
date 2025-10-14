package com.galacticware.griddle.domain.design.base.layer

import com.galacticware.griddle.domain.util.toPascalCase

interface ICharSet {
    val name: String get() = this::class.simpleName?.toPascalCase()?: ""
}