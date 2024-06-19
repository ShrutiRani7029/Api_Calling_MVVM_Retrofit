package com.example.fundamentalskotlin.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fundamentalskotlin.models.QuoteList
import com.example.fundamentalskotlin.repository.QuoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: QuoteRepository): ViewModel() {

    init{
        viewModelScope.launch(Dispatchers.IO) {
            repository.getQuotes(1)
        }
    }
    //access live data
    val quotes : LiveData<QuoteList>
        get() = repository.quotes
}

//jb bhi hm parametrized view model dfeine krte hai hme factory define krni hoti hai isme hm krenge: mainviewmodelfactory