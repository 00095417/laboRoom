package com.example.laboroom.database.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.laboroom.database.RoomDB
import com.example.laboroom.database.entites.GithubRepo
import com.example.laboroom.database.repositories.GithubRepoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GithubRepoViewModel(app: Application):AndroidViewModel(app) {

    private val repository: GithubRepoRepository

    init {
        val repoDAO = RoomDB.getInstance(app).repoDAO()

        repository = GithubRepoRepository(repoDAO)
    }

    fun getReposList(): LiveData<List<GithubRepo>> = repository.getAll()

    fun insert(repo: GithubRepo) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(repo)
    }

}
