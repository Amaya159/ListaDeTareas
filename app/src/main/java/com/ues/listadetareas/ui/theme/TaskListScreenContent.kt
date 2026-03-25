package com.ues.listadetareas.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ues.listadetareas.domain.Task

@Composable
fun TaskListScreenContent(
    tasks: List<Task>,
    onToggleDone: (Task) -> Unit,
    onEditTask: (Task) -> Unit
) {
    if (tasks.isEmpty()) {
        Box(
            modifier = Modifier.Companion.fillMaxSize(),
            contentAlignment = Alignment.Companion.Center
        ) {
            Text(
                "No hay tareas en esta sección",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Companion.Gray
            )
        }
    } else {
        LazyColumn(
            modifier = Modifier.Companion
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(tasks) { task ->
                TaskItem(
                    task = task,
                    onToggleDone = { onToggleDone(task) },
                    onEdit = { onEditTask(task)}
                )
            }
        }
    }
}
@Composable
fun TaskItem(
    task: Task,
    onToggleDone: () -> Unit,
    onEdit: () -> Unit
) {
        Card(
            modifier = Modifier.Companion.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Row(
                modifier = Modifier.Companion
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.Companion.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.Companion.CenterVertically,
                    modifier = Modifier.Companion.weight(1f)
                ) {
                    if (task.isDone) {
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = "Completada",
                            tint = Color(0xFF4CAF50)
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Default.Warning,
                            contentDescription = "Pendiente",
                            tint = Color(0xFFFF9800)
                        )
                    }
                    Spacer(modifier = Modifier.Companion.width(12.dp))
                    Column {
                        Text(
                            text = task.title,
                            style = MaterialTheme.typography.titleMedium
                        )
                        if (task.description.isNotBlank()) {
                            Text(
                                text = task.description,
                                style = MaterialTheme.typography.bodySmall,
                                color = Color.Companion.Gray
                            )
                        }
                    }
                }
                Row {
                    IconButton(onClick = onToggleDone) {
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = "Cambiar estado",
                            tint = if (task.isDone) Color(0xFF4CAF50) else
                                Color.Companion.LightGray
                        )
                    }
                    IconButton(
                        onClick = onEdit,
                        enabled = !task.isDone
                    ) {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = "Editar",
                            tint = if (task.isDone) Color.Companion.LightGray else
                                MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
        }
}