package com.jgduckie.pruebas_retrofit.service

import com.jgduckie.pruebas_retrofit.model.ArticleDto
import com.jgduckie.pruebas_retrofit.model.ArticleModel
import com.jgduckie.pruebas_retrofit.model.articleMapper
import retrofit2.Call
import retrofit2.http.GET


interface GetDataService {
    @GET("articles")
    fun getArticles(): Call<List<ArticleDto>>

}