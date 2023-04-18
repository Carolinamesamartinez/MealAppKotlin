package com.cmesamartinez.proyecto_appandroidconkotlin.data.model

import com.google.gson.annotations.SerializedName

data class BugsModel (
    @SerializedName("id") val bugsid:String,
    @SerializedName("name") val nameEU:nameEuResult,
    @SerializedName("image_uri") val bugsImage:String
        )

data class nameEuResult(
    @SerializedName("name-EUen") val Realname:String
)
