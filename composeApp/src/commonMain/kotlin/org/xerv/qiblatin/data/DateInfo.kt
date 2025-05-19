package org.xerv.qiblatin.data

@Serializable
data class DateInfo(
    val readable: String,
    val timestamp: String,
    val gregorian: GregorianDate,
    val hijri: HijriDate
)
