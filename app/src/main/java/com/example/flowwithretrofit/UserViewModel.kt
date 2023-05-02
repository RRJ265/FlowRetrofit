package com.example.flowwithretrofit

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class UserViewModel() : ViewModel() {

    val userRepo: UserRepo = UserRepoImpl(RetrofitBuilder.apiService)

    fun getUsers() {
        viewModelScope.launch {
            userRepo.getUsers()
                .flowOn(Dispatchers.IO)
                .catch { }
                .collect {
                    Log.e("Users-", it.toString())
                }
        }
    }
}