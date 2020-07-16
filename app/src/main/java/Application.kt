import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import it.iquii.test.reddit.library.android.BuildConfig
import timber.log.Timber

@HiltAndroidApp
class IquiiTestApplication : Application(){

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())

        }
    }

}