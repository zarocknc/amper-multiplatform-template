import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import di.sharedModule
import org.koin.compose.KoinMultiplatformApplication
import org.koin.dsl.KoinConfiguration

@Composable
fun App() {
    KoinMultiplatformApplication(
        config = KoinConfiguration(config = {
            modules(sharedModule)
        })
    ) {
        MaterialTheme() {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // BasicText("Hello, World!")
                FoodScreen()
            }
        }
    }
//    KoinApplication(application = {
//        modules(sharedModule)
//    }) {
//
//    }

}
