package it.subito.test.punkapi.di

import android.content.Context
import coil.ImageLoader
import coil.util.DebugLogger
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import it.subito.test.punkapi.BuildConfig
import it.subito.test.punkapi.domain.repository.network.RestApi
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object CoreModule {
    object BaseUrl {
        private const val BASE_URL = "https://api.punkapi.com/v2/"

        fun getUrl(): String {
            return BASE_URL
        }
    }

    @Singleton
    @Provides
    fun provideRetrofit(json: Json, okHttpClient: OkHttpClient): Retrofit {
        val contentType = "application/json"
        return Retrofit.Builder()
            .addConverterFactory(json.asConverterFactory(contentType.toMediaType()))
            .baseUrl(BaseUrl.getUrl())
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideJsonConfiguration(): Json {
        return Json {
            encodeDefaults = false
            ignoreUnknownKeys = true
            isLenient = false
            allowStructuredMapKeys = false
            prettyPrint = true
            useArrayPolymorphism = false
            classDiscriminator = ""

        }
    }

    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit): RestApi {
        return retrofit.create(RestApi::class.java)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(interceptors: ArrayList<Interceptor>): OkHttpClient {
        val clientBuilder = OkHttpClient.Builder()
            .followRedirects(false)
        interceptors.forEach {
            clientBuilder.addInterceptor(it)
        }
        return clientBuilder.build()
    }


    @Singleton
    @Provides
    fun provideInterceptors(): ArrayList<Interceptor> {
        val interceptors = arrayListOf<Interceptor>()
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = if(BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
        interceptors.add(loggingInterceptor)
        return interceptors
    }

    @Provides
    fun provideCoilImageLoader(@ApplicationContext context: Context): ImageLoader {
        return if(BuildConfig.DEBUG) {
            ImageLoader.Builder(context).logger(DebugLogger()).build()
        } else {
            ImageLoader.Builder(context).build()
        }
    }
}