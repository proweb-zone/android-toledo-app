package toledo24.pro.data.room

import androidx.room.*

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(userEntity: UserEntity)

    @Query("SELECT * FROM UserEntity WHERE id == :id")
    suspend fun getUserById(id: Int): UserEntity

    @Query("SELECT * FROM UserEntity")
    suspend fun getUser(): UserEntity

    @Delete
    suspend fun deleteUser(userEntity: UserEntity)

}