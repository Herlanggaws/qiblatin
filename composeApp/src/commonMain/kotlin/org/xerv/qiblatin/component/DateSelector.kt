package org.xerv.qiblatin.component


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DateSelector(
    selectedDate: String,
    onDateChanged: (String) -> Unit
) {
    val dates = listOf("15 May", "16 May", "17 May", "18 May", "19 May")

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

