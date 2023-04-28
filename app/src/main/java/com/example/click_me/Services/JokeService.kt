package com.example.click_me.Services

import com.example.click_me.domain.Joke
import com.google.gson.Gson
import okhttp3.Call
import okhttp3.Callback
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class JokeService {
    private val client = OkHttpClient()
    private val gson = Gson()
    private val url = HttpUrl.Builder()
        .scheme("https")
        .host("v2.jokeapi.dev")
        .addPathSegment("joke")
        .addPathSegment("Any")
        .addQueryParameter("safe-mode", "")
        .build()

    fun getRandomJoke(callBack: (Joke?) -> Unit) {
        val request = buildHttpRequest()

        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val result = response.body?.string()
                val joke = gson.fromJson(result, Joke::class.java)
                callBack(joke)
            }

            override fun onFailure(call: Call, e: IOException) {
                throw e
            }
        })
    }

    private fun buildHttpRequest() = Request.Builder().url(url).build()


}
