package toledo24.pro.domain.repository

import retrofit2.Call
import toledo24.pro.data.network.ResponseCheckTokenUser
import toledo24.pro.data.room.UserEntity

interface UserRepository {

    suspend fun deleteUserRoom(userEntity: UserEntity)

    suspend fun insertUserRoom(userEntity: UserEntity)

    suspend fun getUserRoom(): UserEntity

    suspend fun checkingTokenUserApi(userEntity: UserEntity): ResponseCheckTokenUser

}