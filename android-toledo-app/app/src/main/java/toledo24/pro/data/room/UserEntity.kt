package toledo24.pro.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    @PrimaryKey
    val id: Int,
    val login: String,
    val token: String,
    val city: String,
    val addr: String,
)
