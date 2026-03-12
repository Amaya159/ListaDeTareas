package com.ues.listadetareas.data.repository

import com.ues.listadetareas.data.TaskDao
import com.ues.listadetareas.data.TaskEntity
import com.ues.listadetareas.domain.Task
import com.ues.listadetareas.domain.TaskRepository

class TaskRepositoryImpl(
    private val dao: TaskDao
): TaskRepository {
    override suspend fun getTasks(): List<Task> {
        return dao.getTasks().map {
            Task(
                id = it.id,
                title = it.title,
                description = it.description,
                isDone = it.isDone
            )
        }
    }
    override suspend fun addTask(task: Task) {
        dao.insertTasks(
            TaskEntity(
                title = task.title,
                description = task.description,
                isDone = task.isDone
            )
        )
    }
    override suspend fun updateTask(task: Task) {
        dao.updateTasks(
            TaskEntity(
                id = task.id,
                title = task.title,
                description = task.description,
                isDone = task.isDone
            )
        )
    }
    override suspend fun deleteTask(task: Task) {
        dao.deleteTasks(
            TaskEntity(
                id = task.id,
                title = task.title,
                description = task.description,
                isDone = task.isDone
            )
        )
    }
}