package org.xerv.qiblatin.presentation.prayerschedule

import org.xerv.qiblatin.domain.models.PrayerResponse
import org.xerv.qiblatin.util.getCurrentDate

data class PrayerScheduleUiState(
    val isLoading: Boolean = false,
    val prayerResponse: PrayerResponse? = null,
    val error: String? = null,
    val selectedDate: String = getCurrentDate()
)