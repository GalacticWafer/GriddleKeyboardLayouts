package com.galacticwarev2.griddle.domain.design.base.layer

import com.galacticwarev2.griddle.domain.language.LayerTag
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonEncoder
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.jsonPrimitive

object CharSetSerializer : KSerializer<CharSet> {
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("CharSet") {
        element("layerTags", ListSerializer(LayerTag.serializer()).descriptor)
    }

    override fun serialize(encoder: Encoder, value: CharSet) {
        val jsonEncoder = encoder as? JsonEncoder
        val layerTags = value.layerTags.toList()
        if (jsonEncoder != null) {
            // Serialize as an object with layerTags property for clarity and forward compatibility
            val json = kotlinx.serialization.json.buildJsonObject {
                put("layerTags", kotlinx.serialization.json.JsonArray(layerTags.map { JsonPrimitive(it.name) }))
            }
            jsonEncoder.encodeJsonElement(json)
        } else {
            // Fallback: serialize as array
            encoder.encodeSerializableValue(ListSerializer(LayerTag.serializer()), layerTags)
        }
    }

    override fun deserialize(decoder: Decoder): CharSet {
        val jsonDecoder = decoder as? JsonDecoder
        val jsonElement = jsonDecoder?.decodeJsonElement()
        return when (jsonElement) {
            is kotlinx.serialization.json.JsonArray -> {
                val layerTags = jsonElement.map {
                    LayerTag.valueOf(it.jsonPrimitive.content)
                }.toTypedArray()
                CharSet.id(*layerTags)
            }
            is JsonPrimitive -> {
                val tag = LayerTag.valueOf(jsonElement.content)
                CharSet.id(tag)
            }
            is JsonObject -> {
                val tagsElement = jsonElement["layerTags"]
                if (tagsElement is kotlinx.serialization.json.JsonArray) {
                    val layerTags = tagsElement.map {
                        LayerTag.valueOf(it.jsonPrimitive.content)
                    }.toTypedArray()
                    CharSet.id(*layerTags)
                } else {
                    throw kotlinx.serialization.SerializationException("Expected 'layerTags' to be a JsonArray in CharSet JsonObject")
                }
            }
            else -> throw kotlinx.serialization.SerializationException("Expected a JsonArray, JsonObject, or single string for CharSet, got: ${jsonElement?.let { it::class.simpleName }}")
        }
    }
}