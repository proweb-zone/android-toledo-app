package toledo24.pro.domain.usecase.catalog

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import toledo24.pro.data.network.CatalogModel
import toledo24.pro.domain.repository.CatalogRepository

class GetCategoriesUseCase(private val catalogRepository: CatalogRepository) {

    fun execute(): Flow<List<CatalogModel>> = flow {
            val response = catalogRepository.getCatalog()
            emit(response.categories)
            delay(1000)
    }

}