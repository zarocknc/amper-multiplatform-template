import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import core.domain.model.Food
import core.domain.usecase.GetFoodUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FoodViewModel(
    private val getFoodUseCase: GetFoodUseCase,
) : ViewModel() {

    private val _food = MutableStateFlow<Food?>(null)
    val food: StateFlow<Food?> = _food

    private val _error = MutableStateFlow<String>("")
    val error: SharedFlow<String> = _error

    fun loadFood() {
        viewModelScope.launch {
            val result = getFoodUseCase()
            result.fold(onSuccess = {
                _food.value = it
            }, onFailure = { exception ->
                _error.emit(exception.message ?: "Unknown Error")
            })
        }
    }
}