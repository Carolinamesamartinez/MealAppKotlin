package com.cmesamartinez.proyecto_appandroidconkotlin.data.model

import com.google.gson.annotations.SerializedName

data class BugsModel (
    val Bugs:List<BugsResponse>

        )

data class nameEuResult(
    @SerializedName("name-EUen") val Realname:String
)

data class BugsResponse(
    @SerializedName("id") val bugsid:String,
    @SerializedName("name") val nameEU:nameEuResult,
    @SerializedName("image_uri") val bugsImage:String
)
