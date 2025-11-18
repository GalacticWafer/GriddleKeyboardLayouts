package com.galacticware.griddle.domain.design.base.gesture

import com.galacticware.griddle.domain.gesture.GestureData.Companion.EMPTY_DATA
import com.galacticware.griddle.domain.model.gesture.GestureType
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.serializer


@OptIn(InternalSerializationApi::class)
object GestureSerializer : KSerializer<Gesture> {
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("Gesture") {
        element("id", GestureType::class.serializer().descriptor)
    }

    override fun serialize(encoder: Encoder, value: Gesture) {
        val composite = encoder.beginStructure(descriptor)
        composite.encodeSerializableElement(descriptor, 0, GestureType::class.serializer(), value.type)
        composite.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): Gesture {
        val dec = decoder.beginStructure(descriptor)
        var id: GestureType? = null

        loop@ while (true) {
            when (val index = dec.decodeElementIndex(descriptor)) {
                0 -> id = dec.decodeSerializableElement(descriptor, 0, GestureType::class.serializer())
                CompositeDecoder.DECODE_DONE -> break@loop
                else -> throw SerializationException("Unexpected index: $index")
            }
        }
        dec.endStructure(descriptor)

        if (id == null) throw SerializationException("Missing id")

        return object : Gesture(EMPTY_DATA, type = id) {}
    }
}
