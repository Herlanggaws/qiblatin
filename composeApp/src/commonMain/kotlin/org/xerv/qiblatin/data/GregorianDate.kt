package org.xerv.qiblatin.data

@Serializable
data class GregorianDate(
    val date: String,
    val format: String,
    val day: String,
    val month: MonthInfo,
    val year: String,
    val weekday: WeekdayInfo
)
