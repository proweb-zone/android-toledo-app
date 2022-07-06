package toledo24.pro.data

import toledo24.pro.data.network.ResponseCatalogModel
import toledo24.pro.domain.repository.CatalogRepository
import toledo24.pro.data.network.RetrofitService
import toledo24.pro.data.network.RetrofitService.Companion.retrofitService

class CatalogRepositoryImpl(retrofitService: RetrofitService): CatalogRepository {

    override suspend fun getCatalog(): ResponseCatalogModel = retrofitService!!.getCatalog()

}