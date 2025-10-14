package com.galacticware.griddle.domain.design.base.button

import com.galacticware.griddle.domain.gesture.GestureData
import com.galacticware.griddle.domain.gesture.GestureDataModel
import com.galacticware.griddle.domain.model.gesture.GestureType

fun MutableMap<GestureType, GestureData>.toMutableModelMap(
    function: (MutableMap.MutableEntry<GestureType, GestureData>) -> Pair<GestureType, GestureDataModel>)
= entries.associate(function).toMutableMap()