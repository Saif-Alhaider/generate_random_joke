package com.example.click_me.Repository

import com.example.click_me.Services.JokeService
import com.example.click_me.domain.Joke

class Repository {
    private val jokeService = JokeService()

    fun getJoke(callback: (Joke?) -> Unit) {
        jokeService.getRandomJoke(callback)
    }

}