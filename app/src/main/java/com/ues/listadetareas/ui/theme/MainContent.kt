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
        NavHost(
            navController = navController,
            startDestination = "task_List"
        ) {
            // composable("splash") { SplashScreen(navController) }

                composable("task_List") {
                    TaskListScreen(
                        viewModel = viewModel,
                        onNavigateToAddTask = { navController.navigate("add_task") }
                    )
                }
                composable("add_task") {
                    AddTaskScreen(
                        viewModel = viewModel,
                        onBack = { navController.popBackStack() }
                    )
                }
            }
        }



    /*Box(modifier = modifier.fillMaxSize()) {
        TaskListScreen(viewModel) {
            navController.navigate("addTask")
        }
    }*/
}