package com.jgduckie.pruebas_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson
import com.jgduckie.pruebas_retrofit.model.ArticleDto
import com.jgduckie.pruebas_retrofit.model.ArticleModel
import com.jgduckie.pruebas_retrofit.model.articleMapper
import com.jgduckie.pruebas_retrofit.retrofit.ApiUtils
import com.jgduckie.pruebas_retrofit.retrofit.RetrofitInstance
import com.jgduckie.pruebas_retrofit.service.GetDataService
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    var articlesdto: ArticleDto? = null
    var apiUtils: ApiUtils = ApiUtils()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var retrofit = apiUtils.generateRetrofitInstance()
        val service = retrofit.create(GetDataService::class.java)


        apiUtils.RequestServer(service)


    }

//
//    fun generateOkHttpBuilder(): OkHttpClient {
//        return OkHttpClient().newBuilder().build()
//    }
//
//    fun generateRetrofitInstance(): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl("http://192.168.1.11:1337/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
//

}