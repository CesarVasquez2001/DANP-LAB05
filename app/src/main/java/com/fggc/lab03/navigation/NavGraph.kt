package com.fggc.lab03.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.fggc.lab03.core.Constants.Companion.ASISTENTE_ID
import com.fggc.lab03.domain.model.Asistente
import com.fggc.lab03.navigation.Screen.*
import com.fggc.lab03.presentation.asistentes.AsistentesScreen
import com.fggc.lab03.presentation.login.components.LoginScreen
import com.fggc.lab03.presentation.update_asistentes.UpdateAsistenteScreen

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = LoginScreen.route
    ) {

        composable(route = Screen.LoginScreen.route) {
            LoginScreen(
                navigateToLoginAsistenteScreen = { loginId ->
                    navController.navigate(
                        "${AsistentesScreen.route}/${loginId}"
                    )
                })
        }
        composable(
            route = "${AsistentesScreen.route}/{loginId}",
            arguments = listOf(
                navArgument("loginId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val loginId = backStackEntry.arguments?.getInt("loginId") ?: 0

            AsistentesScreen(
                loginId = loginId,
                navigateToUpdateAsistenteScreen = { asistenteId ->
                    navController.navigate(
                        "${UpdateAsistenteScreen.route}/${asistenteId}"
                    )
                }
            )
        }
        composable(
            route = "${UpdateAsistenteScreen.route}/{$ASISTENTE_ID}",
            arguments = listOf(
                navArgument(ASISTENTE_ID) {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val asistenteId = backStackEntry.arguments?.getInt(ASISTENTE_ID) ?: 0
            UpdateAsistenteScreen(
                asistenteId = asistenteId,
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}