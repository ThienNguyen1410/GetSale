package com.thiennguyen.getsale.api

import com.thiennguyen.getsale.data.TikiResults
import retrofit2.http.GET
import retrofit2.http.Query

interface APIClient {
        @GET("search/tiki?")
        fun getTest(@Query("search_term") term : String) : retrofit2.Call<TikiResults>
}