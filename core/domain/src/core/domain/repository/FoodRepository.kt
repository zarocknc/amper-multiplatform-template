package core.domain.repository

import core.domain.model.Food

interface FoodRepository {
    suspend fun getRandomFoodImage(): Result<Food>
}