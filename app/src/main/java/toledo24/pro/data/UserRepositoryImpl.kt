package toledo24.pro.data

import retrofit2.Call
import toledo24.pro.data.network.ResponseCheckTokenUser
import toledo24.pro.data.room.UserEntity
import toledo24.pro.domain.repository.UserRepository
import toledo24.pro.data.network.RetrofitService
import toledo24.pro.data.network.RetrofitService.Companion.retrofitService
import toledo24.pro.data.room.RoomService

/**
 * class for working repository User
 */
class UserRepositoryImpl(
    retrofitService: RetrofitService,
    roomService: RoomService
): UserRepository {

    override suspend fun getUserRoom(): UserEntity {
       return RoomService.INSTANCE?.userDao()!!.getUser()
    }

    override suspend fun insertUserRoom(userEntity: UserEntity) {
        RoomService.INSTANCE?.userDao()!!.insertUser(userEntity)
    }

    override suspend fun deleteUserRoom(userEntity: UserEntity) {
        RoomService.INSTANCE?.userDao()!!.deleteUser(userEntity)
    }

    override suspend fun checkingTokenUserApi(userEntity: UserEntity): ResponseCheckTokenUser = retrofitService!!.checkTokenUser(userEntity)

}