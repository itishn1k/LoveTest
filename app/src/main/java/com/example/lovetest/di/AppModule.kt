package com.example.lovetest.di

import android.content.Context
import android.content.SharedPreferences
import com.example.lovetest.data.Prefs
import com.example.lovetest.remote.LoveApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideLoveApi(): LoveApi {
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(LoveApi::class.java)
    }

//       @Singleton
//       @Provides
//       fun provideSharedPreference(@ApplicationContext context: Context): SharedPreferences {
//           return context.getSharedPreferences("preferences_name", Context.MODE_PRIVATE)
//       }

    @Provides
    @Singleton
    fun providePrefs(@ApplicationContext context: Context): Prefs {
        return Prefs(context)
    }
}