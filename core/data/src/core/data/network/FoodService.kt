package core.data.network

import core.data.network.dto.response.FoodResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header

class FoodService(private val client: HttpClient) {
    suspend fun getRandomFood(): FoodResponse {
        return client.get("https://foodish-api.com/api") {
            header("accept", "application/json")
        }.body()
    }
}