package com.jgduckie.pruebas_retrofit.retrofit

import android.content.res.Resources
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson
import com.jgduckie.pruebas_retrofit.R
import com.jgduckie.pruebas_retrofit.model.ArticleDto
import com.jgduckie.pruebas_retrofit.model.articleMapper
import com.jgduckie.pruebas_retrofit.service.GetDataService
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.jgduckie.pruebas_retrofit.model.ArticleModel as ArticleModel

class ApiUtils {
    private val HOST_ENDPOINT = "http://192.168.1.11:1337/"

    companion object {
        private fun generateOkHttpBuilder(): OkHttpClient {
            return OkHttpClient().newBuilder().build()
        }
    }


    fun generateRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(this.HOST_ENDPOINT)
            .client(generateOkHttpBuilder())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    fun RequestServer(retrofit: GetDataService): List<ArticleModel>? {

        var mapper: articleMapper = articleMapper()
        var lista: List<ArticleModel>? = null
        retrofit.getArticles().enqueue(object : Callback<List<ArticleDto>> {
            override fun onResponse(
                call: Call<List<ArticleDto>>,
                response: Response<List<ArticleDto>>
            ) {
                var articles = response?.body()
                if (articles != null) {
                    lista = mapper.transform(articles)
                    Log.i("RETROFIT", Gson().toJson(lista))
                }

                Log.i("RETROFIT", Gson().toJson(articles))
//                Toast.makeText(applicationContext, Gson().toJson(articles), Toast.LENGTH_LONG)
//                    .show()

            }

            override fun onFailure(call: Call<List<ArticleDto>>, t: Throwable) {


                t?.printStackTrace()
            }
        })
        return lista

    }
}