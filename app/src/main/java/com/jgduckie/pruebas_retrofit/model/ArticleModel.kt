package com.jgduckie.pruebas_retrofit.model

import android.icu.text.CaseMap
import com.google.gson.annotations.SerializedName
import java.time.LocalDate

class ArticleModel {
    private var _id: String = ""
    private var title: String? = null
    private var content: String? = null

    constructor(_id: String, title: String, content: String) {
        this._id = _id
        this.title = title
        this.content = content


    }


    override fun toString(): String {
        return "ArticleModel(_id='$_id', title=$title, content=$content)"
    }


}