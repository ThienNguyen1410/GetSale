package com.thiennguyen.getsale.repo

import android.util.Log
import android.widget.Toast
import com.thiennguyen.getsale.api.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class SearchRepo (private val apiService : ApiService ){
    fun searchProduct (term : String) {
        val apiCall = apiService.search(term)
        apiCall.enqueue(object  : retrofit2.Callback<SearchTerm> {
            override fun onResponse(call: Call<SearchTerm>?, response: Response<SearchTerm>?) {
                val body = response?.body()
                println("-------------------------------------------")
                println("The post response : " + body.toString() + (" |"))
                println("-------------------------------------------")
            }

            override fun onFailure(call: Call<SearchTerm>?, t: Throwable?) {
                println("Failll ->>>>> ERR : " + t.toString())
            }

        })
    }

    fun testSearchApi(searchTerm : String) {
        val apiCall = apiService.search(searchTerm)
        apiCall.enqueue(object : retrofit2.Callback<SearchTerm> {
            override fun onResponse(call: Call<SearchTerm>?, response: Response<SearchTerm>?) {
                val body = response?.body()
                println("-------------------------------------------")
                println("The post response : " + body.toString() + (" |"))
                println("-------------------------------------------")
            }

            override fun onFailure(call: Call<SearchTerm>?, t: Throwable?) {
                println("")
            }
        })
    }
}