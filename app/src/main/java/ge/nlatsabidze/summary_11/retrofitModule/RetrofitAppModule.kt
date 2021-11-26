package ge.nlatsabidze.summary_11.retrofitModule

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ge.nlatsabidze.summary_11.Constants.ConstantsUrl
import ge.nlatsabidze.summary_11.network.Api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory


@Module
@InstallIn(SingletonComponent::class)
object RetrofitAppModule {

    @Provides
    fun provideBaseUrl() = ConstantsUrl.BASE_URL

    @Provides
    @Singleton
    fun provideRetrofitInstance(BASE_URL: String): Api =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()))
            .build()
            .create(Api::class.java)
}

