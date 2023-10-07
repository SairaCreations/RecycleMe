package com.sairacreations.recycleme

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class RecyleApplication :Application(){
    val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy {RecycleRoomDatabase.getDatabase(this,applicationScope)}
    val repository by lazy { RecycleRepository(database.userDao())}
}