package it.subito.test.punkapi

import android.app.Application
import coil.Coil
import coil.ImageLoader
import coil.util.CoilUtils
import coil.util.DebugLogger
import dagger.hilt.android.HiltAndroidApp
import it.subito.test.punkapi.library.android.BuildConfig
import okhttp3.OkHttpClient
import timber.log.Timber

@HiltAndroidApp
class PunkApiTestApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())

        }

        val imageLoader = ImageLoader.Builder(this)
            .crossfade(true)
            .logger(DebugLogger()) //Added for convinience
            .okHttpClient {
                OkHttpClient.Builder()
                    .cache(CoilUtils.createDefaultCache(this))
                    .build()
            }
            .build()
        Coil.setImageLoader(imageLoader)
    }

}