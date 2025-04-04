package core.data.local

import org.koin.core.module.Module
import org.koin.dsl.module

actual fun databaseModule(): Module = module {
    single<AppDatabase> {
        val builder = getDatabaseBuilder()
        getAppDatabase(builder)
    }
}