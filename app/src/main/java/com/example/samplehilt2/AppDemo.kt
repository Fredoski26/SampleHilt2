package com.example.samplehilt2

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AppDemo: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}