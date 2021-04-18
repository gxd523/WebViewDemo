package com.demo.webview

import android.app.Application

/**
 * Created by guoxiaodong on 4/16/21 17:37
 */
class MyApplication : Application() {
    companion object {
        lateinit var instance: Application
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}