import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import org.koin.compose.koinInject

@Composable
fun FoodScreen(viewModel: FoodViewModel = koinInject()) {
    val food by viewModel.food.collectAsState()
    val errorMessage by viewModel.error.collectAsState(null)
    var isLoading by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        viewModel.loadFood()
    }
    Column {
        when {
            isLoading -> {
                CircularProgressIndicator()
            }

            food != null -> {
                BasicText(food!!.imageURl)
            }

            errorMessage != null -> {
                BasicText("ERROR!!: $errorMessage")
            }
        }
    }
}