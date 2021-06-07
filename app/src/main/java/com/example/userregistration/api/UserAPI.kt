package com.example.userregistration.api


import com.example.userregistration.model.UserDataSubList
import com.example.userregistration.utils.Constants.API_ENDPOINT
import com.example.userregistration.model.UserResponse
import retrofit2.Response
import retrofit2.http.GET

interface UserAPI {

    @GET(API_ENDPOINT)
    suspend fun getUserDAta():Response<List<UserResponse>>

}