package core.data.repository

import core.data.local.dao.FoodDao
import core.data.local.entity.toDomain
import core.data.network.FoodService
import core.data.network.dto.response.toEntity
import core.domain.model.Food
import core.domain.repository.FoodRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

class FoodRepositoryImpl(
    private val foodService: FoodService,
    private val foodDao: FoodDao,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : FoodRepository {
    override suspend fun getRandomFoodImage(): Result<Food> = withContext(dispatcher) {
        try {
            val networkFood = foodService.getRandomFood()
            val entity = networkFood.toEntity()
            foodDao.insertFood(entity)
            Result.success(entity.toDomain())
        } catch (e: Exception) {
            try {
                val cachedFood = foodDao.getFood()
                cachedFood?.let {
                    Result.success(it.toDomain())
                } ?: Result.failure(e)
            } catch (dbException: Exception) {
                Result.failure(dbException)
            }
        }
    }
}