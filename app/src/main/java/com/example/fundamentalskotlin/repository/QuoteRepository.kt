package com.example.fundamentalskotlin.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.fundamentalskotlin.api.QuoteService
import com.example.fundamentalskotlin.models.QuoteList

class QuoteRepository(private val quoteService: QuoteService) {

    private val quotesLiveData = MutableLiveData<QuoteList>() //mutable live data

    //publicly accessible live data
    val quotes: LiveData<QuoteList>
        get() = quotesLiveData    //for accessing mutable live data


    suspend fun getQuotes(page: Int){
        val result = quoteService.getQuotes(page)
        if(result!=null && result.body()!=null){
          quotesLiveData.postValue(result.body())
        }
    }
}

//hm apni repositories ko access krenge aur repository quoteservice ko access kregi
//quoteservice api ko hit kr rhi
//yha repository hmare data ko manage krne ke use  hoti hai