package com.fggc.lab03.navigation

import com.fggc.lab03.core.Constants.Companion.ASISTENTES_SCREEN
import com.fggc.lab03.core.Constants.Companion.LOGIN_SCREEN
import com.fggc.lab03.core.Constants.Companion.UPDATE_ASISTENTES_SCREEN

sealed class Screen(val route: String){
    object AsistentesScreen: Screen(ASISTENTES_SCREEN)
    object UpdateAsistenteScreen: Screen(UPDATE_ASISTENTES_SCREEN)
    object LoginScreen: Screen(LOGIN_SCREEN)
}
