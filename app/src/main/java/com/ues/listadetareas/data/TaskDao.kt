package com.ues.listadetareas.data

import androidx.room.*
import com.ues.listadetareas.domain.Task

@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks")
    suspend fun getTasks(): List<TaskEntity>

    @Insert
    suspend fun insertTasks(task: TaskEntity)

    @Update
    suspend fun updateTasks(task: TaskEntity)

    @Delete
    suspend fun deleteTasks(task: TaskEntity)
}