package core.data

import core.data.local.localModule
import core.data.network.networkModule
import core.data.repository.FoodRepositoryImpl
import core.domain.repository.FoodRepository
import org.koin.dsl.module


val dataModule = module {
    includes(localModule, networkModule)
    single<FoodRepository> { FoodRepositoryImpl(get(), get()) }
}