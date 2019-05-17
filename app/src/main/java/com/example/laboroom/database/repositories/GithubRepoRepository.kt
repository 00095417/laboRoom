package com.example.laboroom.database.repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.laboroom.database.daos.GithubRepoDAO
import com.example.laboroom.database.entites.GithubRepo

class GithubRepoRepository(private val repoDAO:GithubRepoDAO) {

    //obtener todo
    fun getAll(): LiveData<List<GithubRepo>> = repoDAO.getAllRepos()
    //borrar
    fun delete() = repoDAO.deletTable()

    @WorkerThread
    suspend fun insert(repo:GithubRepo) = repoDAO.insert(repo)


}