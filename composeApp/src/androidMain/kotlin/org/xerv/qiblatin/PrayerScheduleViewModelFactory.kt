package org.xerv.qiblatin


import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.dsl.module
import org.xerv.qiblatin.domain.usecase.GetPrayerTimesUseCase
import org.xerv.qiblatin.presentation.prayerschedule.PrayerScheduleViewModel

val androidViewModelModule = module {
    factory {
        PrayerScheduleViewModel(
            getPrayerTimesUseCase = get<GetPrayerTimesUseCase>(),
            coroutineScope = CoroutineScope(Dispatchers.Main + SupervisorJob())
        )
    }
}