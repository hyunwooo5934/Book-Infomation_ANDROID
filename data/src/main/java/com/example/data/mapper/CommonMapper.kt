package com.example.data.mapper

import com.example.data.db.entity.SearchWordEntity
import com.example.domain.model.SearchWord
import com.example.domain.model.bookModel


object CommonMapper {

    fun bookMapper(list : List<com.example.data.model.bookItem>) : List<bookModel> {
        return list.toList().map {
            bookModel (
                title = it.title,
                link = it.link,
                image = it.image,
                author = it.author,
                discount = it.discount,
                publisher = it.publisher,
                pubdate = it.pubdate,
                isbn = it.isbn,
                description = it.description
            )
        }
    }

    fun itemToEntity(searchWord: SearchWord) : SearchWordEntity = SearchWordEntity(searchWord.keyDate,searchWord.word)
    fun itemToModel(entityList: List<SearchWordEntity>) : List<SearchWord> {
        return entityList.toList().map {
            SearchWord(
                keyDate = it.keyDate,
                word = it.word
            )
        }
    }

}