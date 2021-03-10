package com.thiennguyen.getsale.repo

import com.thiennguyen.getsale.api.*
import com.thiennguyen.getsale.data.TikiResult
import retrofit2.Call
import retrofit2.Response

class SearchRepo (private val apiService : ApiService ){
    fun searchProduct (term : String, callBack : (List<TikiResult.TikiData>) -> Unit) {
        val apiCall = apiService.search(term)
        apiCall.enqueue(object  : retrofit2.Callback<TikiResult> {
            override fun onResponse(call: Call<TikiResult>?, response: Response<TikiResult>?) {
                val body = response?.body()
                println("-------------------------------------------")
                println("The post response : " + body.toString() + (" |"))
                println("-------------------------------------------")
            }

            override fun onFailure(call: Call<TikiResult>?, t: Throwable?) {
                println("Failll ->>>>> ERR : " + t.toString())
            }

        })
    }

    fun testSearchApi(searchTerm : String) {
        val apiCall = apiService.search(searchTerm)
        apiCall.enqueue(object : retrofit2.Callback<TikiResult> {
            override fun onResponse(call: Call<TikiResult>?, response: Response<TikiResult>?) {
                val body = response?.body()
                println("-------------------------------------------")
                println("The post response : " + body.toString() + (" |"))
                println("-------------------------------------------")
            }

            override fun onFailure(call: Call<TikiResult>?, t: Throwable?) {
                println("")
            }
        })
    }
}