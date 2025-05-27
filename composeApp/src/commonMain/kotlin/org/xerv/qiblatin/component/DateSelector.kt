package org.xerv.qiblatin.component


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.datetime.Clock
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.Month
import kotlinx.datetime.TimeZone
import kotlinx.datetime.plus
import kotlinx.datetime.toLocalDateTime

@Composable
fun DateSelector(
    selectedDate: String,
    onDateChanged: (String) -> Unit
) {
    val dates = remember {
        val today = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date
        (0..4).map { dayOffset ->
            val date = today.plus(dayOffset, DateTimeUnit.DAY)
            "${date.dayOfMonth} ${getMonthAbbreviation(date.month)}"
        }
    }

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        itemsIndexed(dates) { index, date ->
            val isSelected = date == selectedDate
            DateItem(
                date = date,
                isSelected = isSelected,
                onClick = { onDateChanged(date) }
            )
        }
    }
}

private fun getMonthAbbreviation(month: kotlinx.datetime.Month): String {
    return when (month) {
        Month.JANUARY -> "Jan"
        Month.FEBRUARY -> "Feb"
        Month.MARCH -> "Mar"
        Month.APRIL -> "Apr"
        Month.MAY -> "May"
        Month.JUNE -> "Jun"
        Month.JULY -> "Jul"
        Month.AUGUST -> "Aug"
        Month.SEPTEMBER -> "Sep"
        Month.OCTOBER -> "Oct"
        Month.NOVEMBER -> "Nov"
        Month.DECEMBER -> "Dec"
        else -> ""
    }
}
