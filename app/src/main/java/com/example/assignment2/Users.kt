package com.example.assignment2

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "users")
data class Users(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo(name = "login") val login: String,
    @ColumnInfo(name = "first_name") val firstName: String,
    @ColumnInfo(name = "last_name") val lastName: String,
    @ColumnInfo(name = "password") val password: String
    )

