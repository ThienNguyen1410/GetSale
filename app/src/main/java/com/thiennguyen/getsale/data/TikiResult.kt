package com.thiennguyen.getsale.data
import kotlinx.serialization.Serializable

@Serializable
data class TikiResult(
    val results : List<TikiData>) {
    @Serializable
    data class TikiData(
        val image : String,
        val name : String,
        val price : Int,
        val rate : Int,
        val supplier : String
    )
}


