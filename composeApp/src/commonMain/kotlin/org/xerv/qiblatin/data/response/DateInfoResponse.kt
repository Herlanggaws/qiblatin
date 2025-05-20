package org.xerv.qiblatin.data.response

import kotlinx.serialization.Serializable

@Serializable
data class DateInfoResponse(
    val readable: String,
    val timestamp: String,
    val gregorian: GregorianDateResponse,
    val hijri: HijriDateResponse
)
