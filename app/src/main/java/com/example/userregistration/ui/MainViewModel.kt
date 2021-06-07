package com.example.userregistration.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.userregistration.api.RetrofitInstance
import com.example.userregistration.model.UserDataSubList
import com.example.userregistration.model.UserDataSubListItem
import com.example.userregistration.model.UserResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val usersLiveData = MutableLiveData<List<UserResponse>>().apply {
        mutableListOf<UserResponse>()
    }

    private val childLiveData = MutableLiveData<List<UserDataSubListItem>>().apply {
        mutableListOf<UserDataSubListItem>()
    }

    val _usersLiveData: LiveData<List<UserResponse>> = usersLiveData

    val _childLiveData: LiveData<List<UserDataSubListItem>> = childLiveData

    private val loadingLiveData = MutableLiveData<Boolean>()
    val _loadingLiveData: LiveData<Boolean> = loadingLiveData

    fun init() {
        CoroutineScope(Dispatchers.IO).launch {
            getUserInfo()
        }
    }

     private suspend fun getUserInfo() {
        loadingLiveData.postValue(true)
        val result = RetrofitInstance.api.getUserDAta()
        if (result.isSuccessful) {
            val items = result.body()
            usersLiveData.postValue(items)
        }
        loadingLiveData.postValue(false)


    }

}