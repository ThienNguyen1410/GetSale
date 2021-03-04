package com.thiennguyen.getsale.api
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonSerializationContext
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.*
import retrofit2.Converter.Factory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

interface ApiService {
    @Headers("Content-Type: application/json")
    @GET("/search?")
    fun search(@Query ("search_term") term : String) : retrofit2.Call<SearchTerm>
        companion object {
            @ExperimentalSerializationApi
            val instance : ApiService by lazy {
                val contentType = "application/json".toMediaType()
                val okhttpClient = OkHttpClient.Builder()
                    .connectTimeout(20,TimeUnit.SECONDS)
                    .readTimeout(20,TimeUnit.SECONDS)
                    .writeTimeout(30,TimeUnit.SECONDS)
                    .build()
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://get-sale.herokuapp.com/")
                    .addConverterFactory(Json.asConverterFactory(contentType))
                    .client(okhttpClient)
                    .build()
                retrofit.create<ApiService>(ApiService::class.java)
            }
    }
}