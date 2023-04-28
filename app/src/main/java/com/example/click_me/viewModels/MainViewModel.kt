package com.example.click_me.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.click_me.Repository.Repository
import com.example.click_me.domain.Joke

class MainViewModel : ViewModel() {
    private val repository = Repository()
    private val _jokeData = MutableLiveData<Joke>()

    init {
        getRandomJoke()
    }
    val jokeData:LiveData<Joke>
        get() = _jokeData

    fun getRandomJoke() {
        repository.getJoke { joke ->
            _jokeData.postValue(joke)
        }
    }

}