import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

class App : Application() {
    companion object {
        lateinit var instance: App
//        @JvmStatic
//        lateinit var appComponent: AppComponent
    }

    init {
        instance = this
    }

    override fun onCreate() {

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)

//        appComponent = DaggerAppComponent.builder()
//            .appModule(AppModule(this))
//            .build()
        super.onCreate()


    }
}