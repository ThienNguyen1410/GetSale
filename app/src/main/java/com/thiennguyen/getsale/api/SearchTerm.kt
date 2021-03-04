package com.thiennguyen.getsale.api

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class SearchTerm(
    val status : String
)
