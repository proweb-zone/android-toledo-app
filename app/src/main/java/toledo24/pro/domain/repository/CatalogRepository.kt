package toledo24.pro.domain.repository

import toledo24.pro.data.network.ResponseCatalogModel

interface CatalogRepository {

    suspend fun getCatalog(): ResponseCatalogModel

}