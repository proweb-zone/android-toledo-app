package toledo24.pro.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import toledo24.pro.presentation.catalog.CatalogFragmentViewModel
import toledo24.pro.presentation.home.NavigationViewModel
import toledo24.pro.presentation.welcome.WelcomeViewModel

val appModule = module {

    viewModel {
        CatalogFragmentViewModel(
            getCategoriesUseCase = get(),
            clickCategoriesUseCase = get()
        )
    }

    viewModel {
        WelcomeViewModel(checkingUserUseCase = get())
    }

    viewModel {
        NavigationViewModel()
    }

}