package com.findapple.findapple.app.di.component

import com.findapple.findapple.app.di.app.BaseApp
import com.findapple.findapple.app.di.module.ActivityModule
import com.findapple.findapple.app.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        (AndroidInjectionModule::class),
        (AppModule::class),
        (ActivityModule::class)
    ]
)
interface AppComponent: AndroidInjector<BaseApp> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: BaseApp): Builder
        fun build(): AppComponent
    }
}