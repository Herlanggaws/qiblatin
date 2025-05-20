package org.xerv.qiblatin.data.response

import kotlinx.serialization.Serializable

@Serializable
data class GregorianMonthResponse(
    val number: Int,
    val en: String
)
