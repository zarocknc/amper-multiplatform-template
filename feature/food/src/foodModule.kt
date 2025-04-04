import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val foodModule = module {
    viewModelOf(::FoodViewModel)
}