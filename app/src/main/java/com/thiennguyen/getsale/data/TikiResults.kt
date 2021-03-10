package com.thiennguyen.getsale.data

data class TikiResults(
    val results : List<TikiData>) {
    data class TikiData(
        val image : String,
        val name : Charsets,
        val price : Int,
        val rate : Int,
        val supplier : String
    )
}


