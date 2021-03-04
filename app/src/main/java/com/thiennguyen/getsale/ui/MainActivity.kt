package com.thiennguyen.getsale.ui

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.SearchView
import androidx.core.content.getSystemService
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.thiennguyen.getsale.R
import com.thiennguyen.getsale.adapter.MainPageRecyclerViewAdapter
import com.thiennguyen.getsale.api.*
import com.thiennguyen.getsale.repo.SearchRepo
import kotlinx.android.synthetic.main.main_page.*
import kotlinx.android.synthetic.main.search_product.*
import kotlinx.serialization.ExperimentalSerializationApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var searchName : String
    override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
        setContentView(R.layout.main_page)
        fab.setOnClickListener {
            createSearchDialog()
        }
        recyclerView = findViewById(R.id.main_page_recylerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MainPageRecyclerViewAdapter()
    }

    private fun createSearchDialog() {
        val builder = AlertDialog.Builder(this)
        // Attach search_product layout to Alert Dialog
        val inputNameLayout = layoutInflater.inflate(R.layout.search_product,null)
        // Use layout attached to call component
        val editTextLayout = inputNameLayout.findViewById<TextInputLayout>(R.id.editTextLayout)
        val buttonTest = inputNameLayout.findViewById<Button>(R.id.searchButton)
        builder.setView(inputNameLayout)
        buttonTest.setOnClickListener {
            var term = editTextLayout.editText?.text.toString()
            searchApi(term)
        }
        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawable(null)

    }
    @ExperimentalSerializationApi
    fun searchApi(searchTerm : String) {
        val apiService = ApiService.instance
        val apiRepo = SearchRepo(apiService)
        apiRepo.searchProduct(searchTerm)
    }
     fun testApi(searchTerm : String) {
         val apiClient = ServiceBuilder.buildService(APIClient::class.java)
         val requestCall = apiClient.getTest(searchTerm)
         requestCall.enqueue(object : Callback<TestData> {
             override fun onResponse(
                 call: Call<TestData>,
                 response: Response<TestData>
             ) {
                 println("Successfully!!!!!!!!!")
                 if(response.isSuccessful) {
                    val test = response.body()!!
                     println(test.toString())

                     Toast.makeText(this@MainActivity,"Test " + test.toString(),Toast.LENGTH_LONG)
                 } else {
                     println("Failed , It not rep")
                 }
             }
             override fun onFailure(call: Call<TestData>?, t: Throwable?) {
                 Toast.makeText(this@MainActivity,"Error : " + t.toString(),Toast.LENGTH_LONG)
                 println("Error : " + t.toString())
             }
         })
     }
}