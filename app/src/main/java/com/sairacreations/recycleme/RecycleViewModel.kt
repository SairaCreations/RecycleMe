package com.sairacreations.recycleme

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class RecycleViewModel(private val repository: RecycleRepository):ViewModel() {
    val count: LiveData<Int> = repository.count.asLiveData()
    fun insert(recycleValues: RecycleValues) = viewModelScope.launch {
        repository.insert(recycleValues)
    }

class RecycleValueFactory(private val repository: RecycleRepository):ViewModelProvider.Factory{

    override fun<T:ViewModel> create(modelClass: Class<T>):T{

        if (modelClass.isAssignableFrom(RecycleViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return RecycleViewModel(repository) as T


        }
        throw IllegalArgumentException("Unknown Viewmodel class")
    }
}



}