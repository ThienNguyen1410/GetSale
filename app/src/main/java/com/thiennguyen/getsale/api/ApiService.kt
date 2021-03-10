package com.thiennguyen.getsale.api
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.thiennguyen.getsale.data.TikiResult
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.http.*
import java.util.concurrent.TimeUnit

interface ApiService {
    @Headers("Content-Type: application/json")
    @GET("/search/tiki?")
    fun search(@Query ("search_term") term : String) : retrofit2.Call<TikiResult>
        companion object {
            @ExperimentalSerializationApi
            val instance : ApiService by lazy {
                val contentType = "application/json".toMediaType()
                val okhttpClient = OkHttpClient.Builder()
                    .connectTimeout(60,TimeUnit.SECONDS)
                    .readTimeout(60,TimeUnit.SECONDS)
                    .writeTimeout(60,TimeUnit.SECONDS)
                    .build()
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://get-sale.herokuapp.com/")
                    .addConverterFactory(Json{ignoreUnknownKeys = true}.asConverterFactory(contentType))
                    .client(okhttpClient)
                    .build()
                retrofit.create<ApiService>(ApiService::class.java)
            }
    }
}