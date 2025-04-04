package core.domain

import core.domain.usecase.GetFoodUseCase
import org.koin.dsl.module

val domainModule = module() {
    factory { GetFoodUseCase(get()) }
}