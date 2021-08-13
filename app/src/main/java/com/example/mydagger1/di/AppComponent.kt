package com.example.mydagger1.di

import com.example.mydagger1.MDApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityBindingModule::class
    ]
)
interface AppComponent : AndroidInjector<MDApp> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun appMovie(app: MDApp): Builder

        fun build(): AppComponent
    }
}