package com.fggc.lab03.presentation.update_asistentes

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.fggc.lab03.presentation.asistentes.AsistentesViewModel
import com.fggc.lab03.presentation.update_asistentes.components.UpdateAsistenteContent
import com.fggc.lab03.presentation.update_asistentes.components.UpdateAsistenteTopBar

@Composable
fun UpdateAsistenteScreen(
    viewModel: AsistentesViewModel = hiltViewModel(),
    asistenteId: Int,
    navigateBack: () -> Unit
){
    LaunchedEffect(Unit){
        viewModel.getAsistente(asistenteId)
    }
    Scaffold(
        topBar = {
            UpdateAsistenteTopBar(
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            UpdateAsistenteContent(
                padding = padding,
                asistente = viewModel.asistente,
                updateNombre = { nombre->
                    viewModel.updateNombre(nombre)
                },
                updateApellido = { apellido->
                    viewModel.updateApellido(apellido)
                },
                updateFechaInscripcion = { fecha_inscripcion->
                    viewModel.updateFechaInscripcion(fecha_inscripcion)
                },
                updateTipoSangre = { tipo_sangre->
                    viewModel.updateTipoSangre(tipo_sangre)
                },
                updateTelefono = { telefono->
                    viewModel.updateTelefono(telefono)
                },
                updateCorreo = { correo->
                    viewModel.updateCorreo(correo)
                },
                updateMontoPagado = { monto_pagado->
                    viewModel.updateFechaInscripcion(monto_pagado)
                },
                updateAsistente = {asistente ->
                    viewModel.updateAsistente(asistente)
                },
                navigateBack = navigateBack
            )
        }
    )
}