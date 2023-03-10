package com.example.myapplication.di

import android.content.Context
import com.example.myapplication.BuildConfig
import com.example.myapplication.service.MoviesApiService
import com.example.myapplication.utils.Constant
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.scope.Scope
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val apiServiceModule = module {

    /**
     * INJECT RETROFIT CLIENT
     */

    single<OkHttpClient> { okHttp(get()) }

    single<Retrofit> { retrofit(get()) }

    /**
     * INJECT INTERFACE SERVICES
     */

    single {
        service<MoviesApiService>()
    }

}

private inline fun <reified T> Scope.service(): T {
    return get<Retrofit>().create(T::class.java)
}

private val loggingInterceptor: Interceptor
    get() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.HEADERS
        level = HttpLoggingInterceptor.Level.BODY
    }



private fun retrofit(okHttpClient: OkHttpClient) = Retrofit.Builder()
    .baseUrl(BuildConfig.BASE_URL)
    .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
    .client(okHttpClient)
    .build()


private fun okHttp(
    appContext: Context
) = OkHttpClient.Builder().apply {


    if (BuildConfig.DEBUG) {
        addInterceptor(loggingInterceptor)
    }

    connectTimeout(Constant.CONNECTIVITY_TIME_OUT, TimeUnit.SECONDS)
    readTimeout(Constant.CONNECTIVITY_TIME_OUT, TimeUnit.SECONDS)

    val headerAuthorizationInterceptor = Interceptor { chain ->

        //Here we can add request headers :  Authorization ...
        var request = chain.request()
        chain.proceed(request)
    }

    addInterceptor(headerAuthorizationInterceptor)
}.build()



