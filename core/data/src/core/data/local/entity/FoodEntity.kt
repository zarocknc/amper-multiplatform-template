package core.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.datetime.Clock


@Entity(tableName = "food")
data class FoodEntity (
    @PrimaryKey val id: Int = 1,
    val imageUrl: String,
    ///val createdAt: Long = System.currentTimeMillis()
    val createdAt: Long = Clock.System.now().toEpochMilliseconds()
)