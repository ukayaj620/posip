package android.team.clandestine.posip.application

import android.app.Application
import android.team.clandestine.posip.BuildConfig
import timber.log.Timber

class PosipApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}