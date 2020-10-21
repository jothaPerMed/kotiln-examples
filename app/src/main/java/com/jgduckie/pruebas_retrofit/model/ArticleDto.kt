package com.jgduckie.pruebas_retrofit.model

import com.google.gson.annotations.SerializedName
import java.time.LocalDate

class ArticleDto(
    @SerializedName("_id") val _id: String,
    @SerializedName("title") val title: String,
    @SerializedName("content") val content: String,
    @SerializedName("image") val image: Any,

    )
