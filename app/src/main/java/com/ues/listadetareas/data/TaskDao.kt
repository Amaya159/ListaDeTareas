package com.ues.listadetareas.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks")
    fun getTasks(): Flow<List<TaskEntity>>

    @Insert
    suspend fun insertTasks(task: TaskEntity)

    @Update
    suspend fun updateTasks(task: TaskEntity)

    @Delete
    suspend fun deleteTasks(task: TaskEntity)
}