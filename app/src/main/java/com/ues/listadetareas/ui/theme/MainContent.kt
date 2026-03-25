package com.ues.listadetareas.ui.theme

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ues.listadetareas.data.TaskViewModel
import com.ues.listadetareas.ui.theme.screens.TaskListScreen

@Composable
fun MainContent(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: TaskViewModel
) {
    Box(modifier = modifier.fillMaxSize()) {


        Box(modifier = modifier.fillMaxSize()) {
            TaskListScreen(viewModel) {
                navController.navigate("addTask")
            }
        }
    }
}