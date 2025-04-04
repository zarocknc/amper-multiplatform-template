package di

import core.data.dataModule
import core.domain.domainModule
import foodModule
import org.koin.dsl.module

val sharedModule = module {
    includes(domainModule, dataModule)
    includes(foodModule)
}