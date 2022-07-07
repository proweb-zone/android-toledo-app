package toledo24.pro.di

import org.koin.dsl.module
import toledo24.pro.domain.usecase.catalog.ClickCategoriesUseCase
import toledo24.pro.domain.usecase.catalog.GetCategoriesUseCase
import toledo24.pro.domain.usecase.welcome.CheckingUserUseCase


val domainModule = module {

    factory<GetCategoriesUseCase> {
        GetCategoriesUseCase(catalogRepository = get())
    }

    factory<ClickCategoriesUseCase> {
        ClickCategoriesUseCase(catalogRepository = get())
    }

    factory<CheckingUserUseCase> {
        CheckingUserUseCase(userRepository = get())
    }

}