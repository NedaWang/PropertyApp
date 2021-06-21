package com.neda.propertyapp.di

import android.content.Context
import com.neda.propertyapp.PropertyApplication
import com.neda.propertyapp.api.PropertyAPI
import com.neda.propertyapp.provider.RetrofitAPI
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
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): PropertyApplication{
        return app as PropertyApplication
    }

    @Singleton
    @Provides
    fun provideRetrofitInstance(): PropertyAPI =
        Retrofit.Builder()
            .baseUrl("https://f213b61d-6411-4018-a178-53863ed9f8ec.mock.pstmn.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitAPI::class.java)

}