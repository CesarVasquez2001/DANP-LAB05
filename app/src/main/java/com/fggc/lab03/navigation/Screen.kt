package com.fggc.lab03.navigation

import com.fggc.lab03.core.Constants.Companion.LOGIN_SCREEN
import com.fggc.lab03.core.Constants.Companion.REPORTES_SCREEN
import com.fggc.lab03.core.Constants.Companion.UPDATE_REPORTES_SCREEN

sealed class Screen(val route: String) {
    object ReportesScreen : Screen(REPORTES_SCREEN)
    object UpdateReporteScreen : Screen(UPDATE_REPORTES_SCREEN)
    object LoginScreen : Screen(LOGIN_SCREEN)
}
