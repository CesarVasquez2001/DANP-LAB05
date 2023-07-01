package com.fggc.lab03.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.fggc.lab03.core.Constants.Companion.PLANTA_ID
import com.fggc.lab03.navigation.Screen.*
import com.fggc.lab03.presentation.reportes.PlantasScreen
import com.fggc.lab03.presentation.login.LoginScreen
import com.fggc.lab03.presentation.reportes.SensorScreen
import com.fggc.lab03.presentation.update_reportes.UpdatePlantaScreen

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = LoginScreen.route
    ) {
        composable(
            route = Screen.LoginScreen.route
        ) {
            LoginScreen(
                navigateToLoginPlantaScreen = { loginId ->
                    navController.navigate(
                        "${PlantasScreen.route}/${loginId}"
                    )
                })
        }
        composable(
            route = "${SensorScreen.route}/{loginId}",
            arguments = listOf(
                navArgument("loginId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val loginId = backStackEntry.arguments?.getInt("loginId") ?: 0

            SensorScreen(
                loginId = loginId,
                navigateToUpdateReporteScreen = { plantaId ->
                    navController.navigate(
                        "${LoginScreen.route}/${plantaId}"
                    )
                }
            )
        }
        composable(
            route = "${PlantasScreen.route}/{loginId}",
            arguments = listOf(
                navArgument("loginId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val loginId = backStackEntry.arguments?.getInt("loginId") ?: 0

            PlantasScreen(
                loginId = loginId,
                navigateToUpdatePlantaScreen = { plantaId ->
                    navController.navigate(
                        "${UpdatePlantasScreen.route}/${plantaId}"
                    )
                }
            )
        }
        composable(
            route = "${UpdatePlantasScreen.route}/{$PLANTA_ID}",
            arguments = listOf(
                navArgument(PLANTA_ID) {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val plantaId = backStackEntry.arguments?.getInt(PLANTA_ID) ?: 0
            UpdatePlantaScreen(
                plantaId = plantaId,
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}