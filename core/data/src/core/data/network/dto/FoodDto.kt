package core.data.network.dto

import core.domain.model.Food
import kotlinx.serialization.Serializable

@Serializable
data class FoodDto (
    val imageUrl: String
)

fun FoodDto.toDomainModel(): Food {
    return Food(
        imageURl = this.imageUrl
    )
}