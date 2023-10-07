package com.sairacreations.recycleme

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM recycle_values")
    fun getItems():List<RecycleValues>

    @Insert
    fun insertAll(vararg values: RecycleValues)

    @Delete
    fun delete(recycleValues: RecycleValues)

    @Query("SELECT COUNT(*) FROM recycle_values")
            fun returnSum():Flow<Int>

}