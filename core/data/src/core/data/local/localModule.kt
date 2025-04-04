package core.data.local

import core.data.local.dao.FoodDao
import org.koin.dsl.module

val localModule = module {
    includes(databaseModule())
    single<FoodDao> { get<AppDatabase>().foodDao() }
}