package com.example.myapplication

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.example.myapplication.di.apiServiceModule
import com.example.myapplication.di.databaseModule
import com.example.myapplication.di.repositoryModule
import com.example.myapplication.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber


class MainApplication : Application() {

    private var mContext: Context? = null


    override fun onCreate() {
        super.onCreate()
        this.mContext = applicationContext
        initTimber()
        initKoin()

    }

    // INIT TIMBER FOR ONLY LOGS IN DEBUG MODE
    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    // KOIN GRAPH INJECTION

    private fun initKoin() {
        startKoin {
            // modules
            androidContext(this@MainApplication)
            modules(
                listOf( apiServiceModule, repositoryModule, viewModelsModule,databaseModule)
            )
        }
    }


    companion object {

        @SuppressLint("StaticFieldLeak")
        private var instance: MainApplication? = null

        @JvmStatic
        fun getInstance(): MainApplication {
            if (instance == null)
                instance = MainApplication()
            return instance as MainApplication
        }

        const val TAG = "BaseApp"

    }

}

