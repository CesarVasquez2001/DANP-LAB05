package com.fggc.lab03.presentation.reportes.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fggc.lab03.domain.model.Planta
import com.fggc.lab03.domain.repository.Plantas


@Composable
fun ReportesContent(
    padding: PaddingValues,
    plantas: Plantas,
    deletePlanta: (planta: Planta) -> Unit,
    navigateToUpdatePlantaScreen: (plantaId: Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ) {
        items(plantas) { planta ->
            PlantaCard(
                planta = planta,
                deletePlanta = {
                    deletePlanta(planta)
                },
                navigateToUpdatePlantaScreen =
                navigateToUpdatePlantaScreen
            )
        }
    }
}