package toledo24.pro.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserEntity::class], version = 1)
abstract class RoomService: RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        var INSTANCE: RoomService? = null

        fun getInstance(context: Context): RoomService {
            if (INSTANCE == null){
                synchronized(RoomService::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, RoomService::class.java, "toledoDB").build()
                }
            }
            return INSTANCE!!
        }

        fun destroyDataBase(){
            INSTANCE = null
        }
    }

}