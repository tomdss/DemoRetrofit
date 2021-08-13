package com.example.mydagger1.di

import com.example.mydagger1.network.MovieService
import com.example.mydagger1.utils.ImageLoader
import dagger.Module
import dagger.Provides

@Module
class AppModule {
    @Provides
    fun provideMovieApi() = MovieService.create()

    @Provides
    fun provideImageLoader() = ImageLoader()
}