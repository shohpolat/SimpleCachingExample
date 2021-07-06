package com.shoh.simplecachingexample.di

import android.app.Application
import androidx.room.Room
import com.shoh.simplecachingexample.BuildConfig
import com.shoh.simplecachingexample.api.api
import com.shoh.simplecachingexample.db.Database
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): api = retrofit.create(api::class.java)

    @Singleton
    @Provides
    fun provideDatabase(app: Application): Database =
        Room.databaseBuilder(app, Database::class.java, "restaurants_database").build()

}