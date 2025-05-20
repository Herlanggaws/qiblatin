package org.xerv.qiblatin.presentation.prayerschedule

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.xerv.qiblatin.domain.usecase.GetPrayerTimesUseCase
import org.xerv.qiblatin.util.getCurrentDate

class PrayerScheduleViewModel(
    private val getPrayerTimesUseCase: GetPrayerTimesUseCase,
    private val coroutineScope: CoroutineScope
) {
    private val _uiState = MutableStateFlow(PrayerScheduleUiState())
    val uiState: StateFlow<PrayerScheduleUiState> = _uiState.asStateFlow()

    init {
        loadPrayerTimes()
    }

    fun loadPrayerTimes(
        city: String = "Jakarta",
        country: String = "Indonesia",
        date: String = getCurrentDate()
    ) {
        coroutineScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)

            getPrayerTimesUseCase(city, country, date)
                .onSuccess { response ->
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        prayerResponse = response,
                        error = null
                    )
                }
                .onFailure { exception ->
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        error = exception.message ?: "Unknown error"
                    )
                }
        }
    }

    fun onDateChanged(newDate: String) {
        _uiState.value = _uiState.value.copy(selectedDate = newDate)
        loadPrayerTimes(date = newDate)
    }
}

