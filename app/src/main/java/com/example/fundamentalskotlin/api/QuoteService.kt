package com.example.fundamentalskotlin.api

import com.example.fundamentalskotlin.models.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteService {

    @GET("/quotes")
    suspend fun getQuotes(@Query("page") page: Int): Response<QuoteList>


    //baseurl + "/quotes" + ?page=1
    //end point ko call krenge


}

