package com.bibbi.domain.model

fun interface SerializableDeepLink {
    fun serialize() : Map<String, String>
}
