package org.xerv.qiblatin.domain.models

import org.xerv.qiblatin.data.response.GregorianMonthResponse

data class GregorianMonth(
    val number: Int,
    val en: String
) {
    constructor(data: GregorianMonthResponse?) : this(
        number = data?.number ?: 0,
        en = data?.en.orEmpty(),
    )
}
