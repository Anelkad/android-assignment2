package com.example.assignment2

import androidx.room.*


@Dao
interface UsersDao {
    @Query("SELECT * FROM users")
    fun getAll(): List<Users>

    @Query("SELECT * FROM users WHERE login = :login AND password = :password")
    fun isUserRegistered(login: String, password: String): Boolean

    @Query("SELECT count() FROM users WHERE login = :login")
    fun isLoginExist(login: String): Boolean

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(student: Users)

    @Delete
    fun delete(student: Users)

    @Query("DELETE FROM users")
    fun deleteAll()
}