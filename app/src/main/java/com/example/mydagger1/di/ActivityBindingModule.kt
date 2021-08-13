package com.example.mydagger1.di

import com.example.mydagger1.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule{

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity


}