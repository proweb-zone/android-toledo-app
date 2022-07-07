package toledo24.pro.presentation.catalog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import toledo24.pro.data.network.CatalogModel
import toledo24.pro.domain.usecase.catalog.ClickCategoriesUseCase
import toledo24.pro.domain.usecase.catalog.GetCategoriesUseCase

class CatalogFragmentViewModel(
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val clickCategoriesUseCase: ClickCategoriesUseCase
): ViewModel() {

    private val _categoriesList = MutableSharedFlow<List<CatalogModel>>()
    val categoriesList = _categoriesList.asSharedFlow()

    private val _stateClickItem = MutableStateFlow<Boolean>(true)
    val stateClickItem = _stateClickItem.asStateFlow()

    /**
     * get list of a categories by api
     */
    init {
        viewModelScope.launch {
            // за емитили все занчения во flow
            _categoriesList.emitAll(
                getCategoriesUseCase.execute()
            )
        }
    }

    /**
     * click item categories
     */
    fun clickCategoriesItem(item: CatalogModel?) {
        viewModelScope.launch {
            _stateClickItem.emit(
            clickCategoriesUseCase.execute(item)
            )
        }
    }

}