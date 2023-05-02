package com.example.flowwithretrofit

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface UserRepo {

    fun getUsers() : Flow<List<User>>
}

class UserRepoImpl(val apiService: ApiService) : UserRepo{
    override fun getUsers(): Flow<List<User>>  = flow {
        emit(apiService.getUsers())
    }
}