package com.example.fundamentalskotlin

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.fundamentalskotlin.api.QuoteService
import com.example.fundamentalskotlin.api.RetrofitHelper
import com.example.fundamentalskotlin.repository.QuoteRepository

import com.example.fundamentalskotlin.viewmodels.MainViewModel
import com.example.fundamentalskotlin.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val repository = QuoteRepository(quoteService)
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)


        mainViewModel.quotes.observe(this, Observer {
            Log.i("CodeSymphonyData", it.results.toString())
        })
        }
    //yha viewmodel ko hmne object bnaya hai
    //ViewModelProvider: ye hme view models bna ke deta hai
    //uske liye hme mainviewmodel me repository ka reference lena pdega
    //means maine factory define kri hai uske through view models ka use krna hai,
    //factory ko repository chahiye thi to val repository = Quo... create kra and
    //repository ko quoteservice chahiye thi to val quoteService = Re ka object bnaya

    //ab hm live data ko aacess krenge

    //ab lastly hm manifest file ke andr permission add krenge
    //<uses-permission android:name="android.permission.INTERNET"></uses-permission>
    }
