package com.example.coroutines.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coroutines.retrofit.ApiClient
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    private val liveData = MediatorLiveData<String>()

    fun getUsers(): LiveData<String> {
        val apiServiceJson = ApiClient.apiService(ApiClient.BASE_URL_JSON)
        val apiServiceGit = ApiClient.apiService(ApiClient.BASE_URL_GITHUB)

        viewModelScope.launch {
            val asyncJson = async { apiServiceJson.getUsersFromJsoPlaceHolder() }
            val asyncGit = async { apiServiceGit.getUsersFromGithub() }

            val awaitJson = asyncJson.await()
            val awaitGit = asyncGit.await()

            val stringBuilder = StringBuilder()

            for (user in awaitJson) {
                stringBuilder.append("Name : ").append(user.name).append("\n")
            }

            for (githubUser in awaitGit) {
                stringBuilder.append("Login : ").append(githubUser.login).append("\n")
            }

            liveData.postValue(stringBuilder.toString())

        }
        return liveData
    }
}