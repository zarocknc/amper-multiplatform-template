package core.domain.usecase

import core.domain.model.Food
import core.domain.repository.FoodRepository

class GetFoodUseCase(private val repository: FoodRepository) {
    suspend operator fun invoke(): Result<Food> = repository.getRandomFoodImage()
}