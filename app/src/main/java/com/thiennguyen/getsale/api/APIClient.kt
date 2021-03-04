package com.thiennguyen.getsale.api

import okhttp3.Call
import okhttp3.RequestBody
import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Query

interface APIClient {
        @GET("search?")
        fun getTest(@Query("search_term") term : String) : retrofit2.Call<TestData>
}