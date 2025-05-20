package org.xerv.qiblatin.data.response

import kotlinx.serialization.Serializable

@Serializable
data class HijriMonthResponse(
    val number: Int,
    val en: String,
    val ar: String,
    val days: Int
)
