package core.data.local

import core.data.local.dao.FoodDao
import org.koin.dsl.module

val provideLocalModule = module {
    single<FoodDao> { get<AppDatabase>().foodDao() }
}