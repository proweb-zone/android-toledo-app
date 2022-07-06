package toledo24.pro.domain.usecase.welcome

import retrofit2.Call
import toledo24.pro.data.network.ResponseCheckTokenUser
import toledo24.pro.data.room.UserEntity
import toledo24.pro.domain.repository.UserRepository

class CheckingUserUseCase(private val userRepository: UserRepository) {

    // get list of User from Room
    suspend fun getUserRoom(): UserEntity {
        return userRepository.getUserRoom()
    }

    suspend fun insertUserRoom(userEntity: UserEntity) {
        userRepository.insertUserRoom(userEntity)
    }

    suspend fun checkingUserToken(userEntity: UserEntity): ResponseCheckTokenUser {
       return userRepository.checkingTokenUserApi(userEntity)
    }

    suspend fun deleteUserRoom(userEntity: UserEntity) {
        userRepository.deleteUserRoom(userEntity)
    }

}