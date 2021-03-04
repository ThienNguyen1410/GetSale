package com.thiennguyen.getsale.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.thiennguyen.getsale.R
import kotlinx.android.synthetic.main.main_page_view_holder.view.*

class MainPageViewHolder(item : View) : RecyclerView.ViewHolder(item){
    val productName1   = item.findViewById<TextView>(R.id.nameProduct1)
    val productPrice1  = item.findViewById<TextView>(R.id.priceProduct1)
    val productRating1 = item.findViewById<TextView>(R.id.ratingProduct1)
    val productBrand1  = item.findViewById<TextView>(R.id.brandProduct1)
    val productName2   = item.findViewById<TextView>(R.id.nameProduct2)
    val productPrice2  = item.findViewById<TextView>(R.id.priceProduct2)
    val productRating2 = item.findViewById<TextView>(R.id.ratingProduct2)
    val productBrand2  = item.findViewById<TextView>(R.id.brandProduct2)
}