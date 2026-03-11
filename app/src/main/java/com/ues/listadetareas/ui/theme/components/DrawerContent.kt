package com.ues.listadetareas.ui.theme.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DrawerContent() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Menú", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(20.dp))

        Text("Lista de Tareas", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(10.dp))

        Text("Acerca de", style = MaterialTheme.typography.bodyLarge)
    }
}