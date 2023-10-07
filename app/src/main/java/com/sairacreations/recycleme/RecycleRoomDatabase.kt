package com.sairacreations.recycleme

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(RecycleValues::class), version = 3, exportSchema = false)
public abstract class RecycleRoomDatabase : RoomDatabase(){
    abstract fun userDao():UserDao

    private class RecycleDatabaseCallback(
        private val scope: CoroutineScope
    ):RoomDatabase.Callback(){

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let {
                database->
                scope.launch {
                   // var userDao = database.userDao()
                   // userDao.deleteAll()
                  //  var recyleValues = RecycleValues(0,"FirstPerson","Bottle","Plastic",1,"2/3/22",1.0)
                  //  userDao.insertAll(recyleValues)
                populateDatabase(database.userDao())
                }

            }
        }

        suspend fun populateDatabase(userDao: UserDao){
            var recyleValues = RecycleValues(0,"FirstPerson","Bottle","Plastic",1,"2/3/22",1.0)
            userDao.insertAll(recyleValues)
        }
    }
    companion object{
        @Volatile
        private var INSTANCE: RecycleRoomDatabase?=null
        fun getDatabase(context:Context,scope: CoroutineScope):RecycleRoomDatabase{

            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RecycleRoomDatabase::class.java,
                    "recycle_database"

                )
                    .addCallback(RecycleDatabaseCallback(scope))
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }

}