package com.fggc.lab03.presentation.reportes.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fggc.lab03.domain.model.Reporte

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ReporteCard(
    reporte: Reporte,
    deleteReporte: () -> Unit,
    navigateToUpdateReporteScreen: (reporteId: Int) -> Unit
){
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .padding(
                start = 8.dp,
                end = 8.dp,
                top = 4.dp,
                bottom = 4.dp
            )
            .fillMaxWidth(),
        elevation = 3.dp,
        onClick = {
            navigateToUpdateReporteScreen(reporte.reporteId)
        }
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Column() {
                Text(reporte.titulo)
                Text(reporte.description)
            }
            Spacer(
                modifier = Modifier.weight(1f)
            )
            DeleteIcon(
                deleteReporte = deleteReporte
            )
        }
    }
}