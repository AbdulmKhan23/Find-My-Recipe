package com.khan.recipefinder.data.network

import android.app.DownloadManager.Query
import com.khan.recipefinder.data.model.Meal
import com.khan.recipefinder.data.model.MealResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json

object MealApiClient {
    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json()
        }
    }

    suspend fun getRandomRecipe():List<Meal>{
        val url = "https://www.themealdb.com/api/json/v1/1/random.php"
        val response = client.get(url).body() as MealResponse
        return response.meals
    }

    suspend fun getSearchRecipe(query: String) : List<Meal> {
        val url = "https://www.themealdb.com/api/json/v1/1/search.php?s=$query"
        val response = client.get(url).body() as MealResponse
        return response.meals
    }
}
