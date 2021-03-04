package com.thiennguyen.getsale.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thiennguyen.getsale.R
import com.thiennguyen.getsale.view.MainPageViewHolder

class MainPageRecyclerViewAdapter : RecyclerView.Adapter<MainPageViewHolder>(){
    var nameProduct1 = arrayOf("Iphone 11","Iphone 12","Iphone 13")
    var nameProduct2 = arrayOf("Iphone 11","Iphone 12","Iphone 13")
    var priceProduct1 = arrayOf(100,200,300)
    var priceProduct2 = arrayOf(200,300,400)
    var ratingProduct1 = arrayOf(23,42,90)
    var ratingProduct2 = arrayOf(13,92,1)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainPageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.main_page_view_holder,parent,false)
        return MainPageViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainPageViewHolder, position: Int) {
        holder.productName1.text = nameProduct1[position]
        holder.productName2.text = nameProduct2[position]
        holder.productPrice1.text = priceProduct1[position].toString()
        holder.productBrand1.text = "Tiki"
        holder.productPrice2.text = priceProduct2[position].toString()
        holder.productRating1.text = ratingProduct1[position].toString()
        holder.productRating2.text = ratingProduct2[position].toString()
        holder.productBrand2.text = "Lazada"

    }

    override fun getItemCount(): Int {
        return nameProduct1.size
    }
}