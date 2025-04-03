package core.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import core.data.local.entity.FoodEntity

@Dao
interface FoodDao {
    @Query("SELECT * FROM food LIMIT 1")
    suspend fun getFood(): FoodEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFood(entify: FoodEntity)
}