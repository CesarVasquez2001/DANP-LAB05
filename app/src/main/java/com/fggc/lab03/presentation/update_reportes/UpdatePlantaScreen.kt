package com.fggc.lab03.presentation.update_reportes

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.fggc.lab03.presentation.reportes.PlantasViewModel
 import com.fggc.lab03.presentation.update_reportes.components.UpdateReporteContext
import com.fggc.lab03.presentation.update_reportes.components.UpdateReporteTopBar

@Composable
fun UpdatePlantaScreen(
    viewModel: PlantasViewModel = hiltViewModel(),
    plantaId: Int,
    navigateBack: () -> Unit
){
    LaunchedEffect(Unit){
        viewModel.getPlanta(plantaId)
    }
    Scaffold(
        topBar = {
            UpdateReporteTopBar(
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            UpdateReporteContext(
                padding = padding,
                planta = viewModel.planta,
                updateTitulo = { titulo->
                    viewModel.updateTitulo(titulo)
                },
                updateDescription = { description->
                    viewModel.updateTitulo(description)
                },
                updateLatitud = { latitud->
                    viewModel.updateLatitud(latitud)
                },
                updateLongitud = { longitud->
                    viewModel.updateLongitud(longitud)
                },
                updateEstado = { estado->
                    viewModel.updateEstado(estado)
                },
                updateComentarios =  { comentarios->
                    viewModel.updateComentarios(comentarios)
                },

                updatePlanta = { planta ->
                    viewModel.updatePlanta(planta)
                },
                navigateBack = navigateBack
            )
        }
    )
}