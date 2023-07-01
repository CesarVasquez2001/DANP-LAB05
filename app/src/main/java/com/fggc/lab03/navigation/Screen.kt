package com.fggc.lab03.navigation

import com.fggc.lab03.core.Constants.Companion.LOGIN_SCREEN
import com.fggc.lab03.core.Constants.Companion.PLANTAS_SCREEN
import com.fggc.lab03.core.Constants.Companion.SENSOR_SCREEN
import com.fggc.lab03.core.Constants.Companion.UPDATE_PLANTAS_SCREEN

sealed class Screen(val route: String) {
    object PlantasScreen : Screen(PLANTAS_SCREEN)
    object UpdatePlantasScreen : Screen(UPDATE_PLANTAS_SCREEN)
    object LoginScreen : Screen(LOGIN_SCREEN)
    object SensorScreen : Screen(SENSOR_SCREEN)
}
