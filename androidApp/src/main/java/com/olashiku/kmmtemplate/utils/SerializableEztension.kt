package com.olashiku.kmmtemplate.utils

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


inline fun <reified T : Any> T.toJson(): String {
    return Json.encodeToString(this)
}

inline fun <reified T : Any> String.fromJson(): T {
    return Json.decodeFromString(this)
}