package com.fggc.lab03.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.fggc.lab03.core.Constants.Companion.REPORTE_ID
import com.fggc.lab03.navigation.Screen.*
import com.fggc.lab03.presentation.reportes.ReportesScreen
import com.fggc.lab03.presentation.login.LoginScreen
import com.fggc.lab03.presentation.reportes.SensorScreen
import com.fggc.lab03.presentation.update_reportes.UpdateReporteScreen

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
                navigateToLoginReporteScreen = { loginId ->
                    navController.navigate(
                        "${SensorScreen.route}/${loginId}"
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
                navigateToUpdateReporteScreen = { reporteId ->
                    navController.navigate(
                        "${LoginScreen.route}/${reporteId}"
                    )
                }
            )
        }
        composable(
            route = "${ReportesScreen.route}/{loginId}",
            arguments = listOf(
                navArgument("loginId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val loginId = backStackEntry.arguments?.getInt("loginId") ?: 0

            ReportesScreen(
                loginId = loginId,
                navigateToUpdateReporteScreen = { reporteId ->
                    navController.navigate(
                        "${UpdateReporteScreen.route}/${reporteId}"
                    )
                }
            )
        }
        composable(
            route = "${UpdateReporteScreen.route}/{$REPORTE_ID}",
            arguments = listOf(
                navArgument(REPORTE_ID) {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val reporteId = backStackEntry.arguments?.getInt(REPORTE_ID) ?: 0
            UpdateReporteScreen(
                reporteId = reporteId,
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}