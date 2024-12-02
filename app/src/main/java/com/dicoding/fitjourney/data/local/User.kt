package com.dicoding.fitjourney.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val fullname: String,
    val username: String,
    val password: String,
    val birthday: String,
    val height: Int,
    val weight: Int,
    val activityLevel: String,
    val goal: String
)