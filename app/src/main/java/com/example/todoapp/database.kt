package com.example.todoapp

import androidx.room.Database
import androidx.room.Entity
import androidx.room.RoomDatabase
import com.example.todo.DAO
import com.example.todo.ddEntity

@Database(entities = [ddEntity::class], version = 1)
abstract class myDatabase :RoomDatabase() {
    abstract fun dao():DAO
}