package com.example.laboroom.database.entites

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "repos")
data class GithubRepo(
    @ColumnInfo(name = "s_name")
    val name: String
) { }