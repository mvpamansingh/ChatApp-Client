package com.example.anonymousx

import android.app.Application
import com.example.anonymousx.data.di.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ChatApplication :Application(){


    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                dataModule
            )
            androidContext(this@ChatApplication)
        }

    }
}