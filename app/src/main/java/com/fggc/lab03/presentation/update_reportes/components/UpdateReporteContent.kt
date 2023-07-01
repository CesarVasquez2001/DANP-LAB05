package com.fggc.lab03.presentation.update_reportes.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fggc.lab03.core.Constants.Companion.ESTADO
import com.fggc.lab03.core.Constants.Companion.ESPECIE
import com.fggc.lab03.core.Constants.Companion.IMAGEN
import com.fggc.lab03.core.Constants.Companion.SENSOR_HUMEDAD
import com.fggc.lab03.core.Constants.Companion.SENSOR_TEMPERATURA
import com.fggc.lab03.core.Constants.Companion.NOMBRE
import com.fggc.lab03.core.Constants.Companion.UPDATE
import com.fggc.lab03.domain.model.Planta

@Composable
fun UpdateReporteContext(
    padding: PaddingValues,
    planta: Planta,
    updateTitulo: (titulo: String) -> Unit,
    updateDescription: (description: String) -> Unit,
    updateLatitud: (latitud: String) -> Unit,
    updateLongitud: (longitud: String) -> Unit,
    updateEstado: (estado: String) -> Unit,
    updateComentarios: (comentarios: String) -> Unit,
    updatePlanta: (planta: Planta) -> Unit,

    navigateBack: () -> Unit,

    ) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = planta.nombre,
            onValueChange = { titulo ->
                updateTitulo(titulo)
            },
            placeholder = {
                Text(NOMBRE)
            }
        )
        Spacer(
            modifier = Modifier
                .height(8.dp)
        )
        TextField(
            value = planta.especie,
            onValueChange = { description ->
                updateDescription(description)
            },
            placeholder = {
                Text(ESPECIE)
            }
        )
        Spacer(
            modifier = Modifier
                .height(8.dp)
        )
        TextField(
            value = planta.sensorHumedad,
            onValueChange = { latitud ->
                updateLatitud(latitud)
            },
            placeholder = {
                Text(SENSOR_HUMEDAD)
            }
        )
        Spacer(
            modifier = Modifier
                .height(8.dp)
        )
        TextField(
            value = planta.sensorTemperatura,
            onValueChange = { longitud ->
                updateLongitud(longitud)
            },
            placeholder = {
                Text(SENSOR_TEMPERATURA)
            }
        )
        Spacer(
            modifier = Modifier
                .height(8.dp)
        )
        TextField(
            value = planta.imagen,
            onValueChange = { estado ->
                updateEstado(estado)
            },
            placeholder = {
                Text(IMAGEN)
            }
        )
        Spacer(
            modifier = Modifier
                .height(8.dp)
        )
        TextField(
            value = planta.estado,
            onValueChange = { comentarios ->
                updateComentarios(comentarios)
            },
            placeholder = {
                Text(ESTADO)
            }
        )

        Button(
            onClick = {
                updatePlanta(planta)
                navigateBack()
            }
        ) {
            Text(UPDATE)
        }
    }
}






