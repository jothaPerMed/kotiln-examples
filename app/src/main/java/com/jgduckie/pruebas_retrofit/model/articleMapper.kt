package com.jgduckie.pruebas_retrofit.model

class articleMapper {
    fun transform(items: List<ArticleDto>): List<ArticleModel> {
        return items.map { transform(it) }
    }

    fun transform(item: ArticleDto): ArticleModel {
        return ArticleModel(
            item._id,
            item.title, item.content, item.image
        )
    }
}