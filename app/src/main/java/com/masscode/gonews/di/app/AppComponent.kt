package com.masscode.gonews.di.app

import com.masscode.gonews.di.core.CoreComponent
import com.masscode.gonews.ui.home.HomeActivity
import dagger.Component

@AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class, ViewModelModule::class]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): AppComponent
    }

    fun inject(activity: HomeActivity)
}