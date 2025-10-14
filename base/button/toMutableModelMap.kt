package com.galacticwarev2.griddle.domain.design.base.button

import com.galacticwarev2.griddle.domain.gesture.GestureData
import com.galacticwarev2.griddle.domain.gesture.GestureDataModel
import com.galacticwarev2.griddle.domain.model.gesture.GestureType

fun MutableMap<GestureType, GestureData>.toMutableModelMap(
    function: (MutableMap.MutableEntry<GestureType, GestureData>) -> Pair<GestureType, GestureDataModel>)
= entries.associate(function).toMutableMap()