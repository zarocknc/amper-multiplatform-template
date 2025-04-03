package core.data.network.dto.response

import core.data.local.entity.FoodEntity
import kotlinx.serialization.Serializable


@Serializable
data class FoodResponse(
    val image: String
)

fun FoodResponse.toEntity(): FoodEntity {
    return FoodEntity(
        imageUrl = this.image
    )
}