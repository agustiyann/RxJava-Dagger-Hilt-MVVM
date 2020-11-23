package com.masscode.gonews

import android.app.Application
import com.masscode.gonews.di.app.AppComponent
import com.masscode.gonews.di.app.DaggerAppComponent
import com.masscode.gonews.di.core.CoreComponent
import com.masscode.gonews.di.core.DaggerCoreComponent

open class MyApplication : Application() {

    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.factory().create(applicationContext)
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(coreComponent)
    }
}