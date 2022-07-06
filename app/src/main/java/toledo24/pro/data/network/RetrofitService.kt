package toledo24.pro.data.network


import androidx.viewbinding.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import toledo24.pro.data.room.UserEntity


interface RetrofitService {

    @Headers("x-api-auth-token: 4e29b4b06a67d740-c66f8314afb9eb01-506f385e1fc5e2dc")
    @GET("getCategories")
    suspend fun getCatalog(): ResponseCatalogModel

    @Headers("x-api-auth-token: 4e29b4b06a67d740-c66f8314afb9eb01-506f385e1fc5e2dc")
    @POST("checkTokenUser")
    suspend fun checkTokenUser(@Body userEntity: UserEntity): ResponseCheckTokenUser

    companion object {
        var retrofitService: RetrofitService? = null
        var httpClient = OkHttpClient.Builder().addInterceptor(
            HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            })
        fun getInstance() : RetrofitService {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://test.toledo24.pro/api/mobile/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }

}