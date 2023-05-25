package com.fggc.lab03.presentation.asistentes.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fggc.lab03.domain.model.Asistente
import com.fggc.lab03.domain.repository.Asistentes


@Composable
fun AsistentesContent(
    padding: PaddingValues,
    asistentes: Asistentes,
    deleteAsistente: (asistente:Asistente) -> Unit,
    navigateToUpdateAsistenteScreen: (asistenteId: Int) -> Unit
){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ){
        items(asistentes){
            asistente->
            AsistenteCard(
                asistente = asistente,
                deleteAsistente = {
                    deleteAsistente(asistente)
                },
                navigateToUpdateAsistenteScreen =
                    navigateToUpdateAsistenteScreen
            )
        }
    }
}