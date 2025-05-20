package org.xerv.qiblatin.util


import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

fun getCurrentDate(): String {
    val now = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date
    val day = now.dayOfMonth.toString().padStart(2, '0')
    val month = now.monthNumber.toString().padStart(2, '0')
    val year = now.year
    return "$day-$month-$year"
}
