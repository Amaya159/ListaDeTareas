package com.ues.listadetareas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.Room
import com.ues.listadetareas.data.AppDatabase
import com.ues.listadetareas.data.TaskViewModel
import com.ues.listadetareas.data.TaskViewModelFactory
import com.ues.listadetareas.data.repository.TaskRepositoryImpl
import com.ues.listadetareas.data.TaskRepository
import com.ues.listadetareas.ui.theme.ListaDeTareasTheme
import com.ues.listadetareas.ui.theme.TaskApp
import kotlin.getValue
import kotlin.lazy

class MainActivity : ComponentActivity() {
    // MainActivity modificado
    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "tasks_db"
        ).build()
    }

    private val repository by lazy { TaskRepositoryImpl(db.taskDao()) }

    private val viewModel: TaskViewModel by viewModels {
        TaskViewModelFactory(repository)
    }
    //Aquí termina la modificación
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListaDeTareasTheme {
                TaskApp(viewModel)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ListaDeTareasTheme {
        TaskApp(viewModel())
    }
}