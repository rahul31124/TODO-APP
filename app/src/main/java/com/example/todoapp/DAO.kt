package com.example.todo

import androidx.room.*
import com.example.todoapp.Cardinfo

@Dao
interface DAO {
    @Insert
    suspend fun insertTask(entity: ddEntity)

    @Update
    suspend fun updateTask(entity: ddEntity)

    @Delete
    suspend fun deleteTask(entity: ddEntity)

    @Query("Delete from to_do")
    suspend fun deleteAll()

    @Query("Select * from to_do")
    suspend fun getTasks():List<Cardinfo>

}