package com.fggc.lab03.presentation.asistentes

import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.fggc.lab03.core.Constants.Companion.ASISTENTES_SCREEN
import com.fggc.lab03.presentation.asistentes.components.AddAsistenteAlertDialog
import com.fggc.lab03.presentation.asistentes.components.AddAsistenteFloatingActionButton
import com.fggc.lab03.presentation.asistentes.components.AsistentesContent

@Composable
fun AsistentesScreen(
    viewModel: AsistentesViewModel = hiltViewModel(),
    navigateToUpdateAsistenteScreen: (asistenteId: Int) -> Unit,
    loginId: Int,

    ){
    val asistentes by viewModel.asistentes.collectAsState(
        initial = emptyList() )

    Scaffold(
        topBar ={
            TopAppBar(title = {
                Text(ASISTENTES_SCREEN+" - "+loginId)
            })
        },
        content = {
            padding->
            AsistentesContent(
                padding = padding,
                asistentes = asistentes,
                deleteAsistente = {
                    asistente ->
                    viewModel.deleteAsistente(asistente)
                },
                navigateToUpdateAsistenteScreen =
                    navigateToUpdateAsistenteScreen
            )
            AddAsistenteAlertDialog(
                openDialog = viewModel.openDialog,
                closeDialog = {
                    viewModel.closeDialog()
                },
                addAsistente = {asistente->
                    viewModel.addAsistente(asistente)
                }
            )
        },
        floatingActionButton = {
            AddAsistenteFloatingActionButton(
                openDialog = {
                    viewModel.openDialog()
                }
            )
        }
    )
}