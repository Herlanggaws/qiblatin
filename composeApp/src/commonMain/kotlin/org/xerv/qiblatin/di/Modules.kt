package org.xerv.qiblatin.di

import io.ktor.client.HttpClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.xerv.qiblatin.data.PrayerTimesApiService
import org.xerv.qiblatin.data.PrayerTimesApiServiceImpl
import org.xerv.qiblatin.data.repository.PrayerTimesRepositoryImpl
import org.xerv.qiblatin.domain.repository.PrayerTimesRepository
import org.xerv.qiblatin.domain.usecase.GetPrayerTimesUseCase
import org.xerv.qiblatin.presentation.prayerschedule.PrayerScheduleViewModel
import org.koin.dsl.module
import org.koin.core.module.Module
import org.xerv.qiblatin.network.createHttpClient

val networkModule = module {
    single<HttpClient> { createHttpClient() }
}

val apiModule = module {
    single<PrayerTimesApiService> { PrayerTimesApiServiceImpl(get()) }
}

val repositoryModule = module {
    single<PrayerTimesRepository> { PrayerTimesRepositoryImpl(get()) }
}

val useCaseModule = module {
    single { GetPrayerTimesUseCase(get()) }
}

val viewModelModule = module {
    factory {
        PrayerScheduleViewModel(
            getPrayerTimesUseCase = get<GetPrayerTimesUseCase>(),
            coroutineScope = CoroutineScope(Dispatchers.Main + SupervisorJob())
        )
    }
}

val appModules: List<Module> = listOf(
    networkModule,
    apiModule,
    repositoryModule,
    useCaseModule,
    viewModelModule
)
