package com.example.test1.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class News(
    @SerialName(value = "name")
    val name: String = "",
    @SerialName(value = "image")
    val image: String = "",
    @SerialName(value = "date")
    val date: String = "",
    @SerialName(value = "id")
    val id: String = ""
) {
    var isFavourite = false
}