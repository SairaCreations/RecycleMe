package com.sairacreations.recycleme

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class RecycleRepository(private val userDao: UserDao) {

    val count:Flow<Int> = userDao.returnSum()
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(recycleValues: RecycleValues){
        userDao.insertAll(recycleValues)
    }

}
