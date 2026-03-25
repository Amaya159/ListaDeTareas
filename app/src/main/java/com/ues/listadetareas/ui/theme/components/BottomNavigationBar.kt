package com.ues.listadetareas.ui.theme.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import com.ues.listadetareas.ui.theme.Blanco
import com.ues.listadetareas.ui.theme.GuindaUES

@Composable
fun BottomNavigationBar(
    selectedTab: Int,
    onTabSelected: (Int) -> Unit
) {
    NavigationBar(
        containerColor = GuindaUES
    ) {
        NavigationBarItem(
            selected = selectedTab == 0,
            onClick = { onTabSelected(0) },
            label = { Text(text = "Pendientes", color = Blanco) },
            icon = { Icon(Icons.Default.List,
                contentDescription = "Pendientes",
                tint = if (selectedTab == 0) Color.Gray else Blanco
            )}
        )
        NavigationBarItem(
            selected = selectedTab == 1,
            onClick = { onTabSelected(1) },
            label = { Text(text = "Completadas", color = Blanco) },
            icon = { Icon(Icons.Default.Check,
                contentDescription = "Completadas",
                tint = if (selectedTab == 1) Color.Gray else Blanco
                ) }
        )
    }
}
