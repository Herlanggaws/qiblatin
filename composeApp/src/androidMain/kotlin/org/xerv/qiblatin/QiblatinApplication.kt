package org.xerv.qiblatin

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.xerv.qiblatin.di.appModules
import org.xerv.qiblatin.di.initKoin

class QiblatinApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@QiblatinApplication)
            modules(appModules + androidViewModelModule)
        }
    }
}