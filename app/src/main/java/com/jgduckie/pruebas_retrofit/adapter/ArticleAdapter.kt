package com.jgduckie.pruebas_retrofit.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.jgduckie.pruebas_retrofit.R
import kotlinx.android.synthetic.main.activity_main.*


import com.jgduckie.pruebas_retrofit.model.ArticleModel
import kotlinx.android.synthetic.main.articles_layout.view.*

class ArticleAdapter(val items: List<ArticleModel>, val listener: (ArticleModel) -> Unit) :
    RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.articles_layout, parent, false)
        )
    }

    //Accion al hacer seleccion sobre el
    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = items.get(position)
        holder._idtxt.text = article._id
        holder._titletxt.text = article.title
        holder._contenttxt.text = article.content

//        holder._image.setImageURI(Uri.fromFile(""))
//        holder.itemView.setOnClickListener {
//
//        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ArticleViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {
        var _idtxt = itemView.idtxt
        var _titletxt = itemView.titletxt
        var _contenttxt = itemView.contenttxt
        var _image = itemView.imageView


    }
}