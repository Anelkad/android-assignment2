package com.example.assignment2

import androidx.room.*


@Dao
interface UsersDao {
    @Query("SELECT * FROM users")
    fun getAll(): List<Users>

    /* @Query("SELECT * FROM student_table WHERE uid IN (:userIds)")
     fun loadAllByIds(userIds: IntArray): List<Student>*/

    @Query("SELECT * FROM users WHERE id LIKE :roll LIMIT 1")
    fun findByRoll(roll: Int): Users

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(student: Users)

    @Delete
    fun delete(student: Users)

    @Query("DELETE FROM users")
    fun deleteAll()
}