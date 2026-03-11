package com.ues.listadetareas.ui.theme

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.ues.listadetareas.ui.theme.components.BottomNavigationBar
import com.ues.listadetareas.ui.theme.components.DrawerContent
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskApp() {
    // Servirá para controlar el Drawer
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent()
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Lista de Tareas") },
                    navigationIcon = {
                        IconButton(
                            onClick = {scope.launch { drawerState.open() } }
                        ) {
                            Icon(Icons.Default.Menu, contentDescription = "Menú")
                        }
                    }
                )
            },
            bottomBar = {
                BottomNavigationBar()
            },
            floatingActionButton = {
                FloatingActionButton(onClick = {/* Acción que premitirá agregar una futura tarea */}) {
                    Icon(Icons.Default.Add, contentDescription = "Agregar tarea")
                }
            }
        ) { innerPadding ->
            // Armaremos la pantalla principal
            MainContent(modifier = Modifier.padding(innerPadding))
        }
    }
}