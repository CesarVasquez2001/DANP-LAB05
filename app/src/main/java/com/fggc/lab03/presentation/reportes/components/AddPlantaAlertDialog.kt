package com.fggc.lab03.presentation.reportes.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fggc.lab03.core.Constants.Companion.ADD
import com.fggc.lab03.core.Constants.Companion.ADD_PLANTA
import com.fggc.lab03.core.Constants.Companion.DISMISS
import com.fggc.lab03.core.Constants.Companion.NO_VALUE
import com.fggc.lab03.core.Constants.Companion.ESTADO
import com.fggc.lab03.core.Constants.Companion.ESPECIE
import com.fggc.lab03.core.Constants.Companion.IMAGEN
import com.fggc.lab03.core.Constants.Companion.SENSOR_HUMEDAD
import com.fggc.lab03.core.Constants.Companion.SENSOR_TEMPERATURA
import com.fggc.lab03.core.Constants.Companion.NOMBRE
import com.fggc.lab03.domain.model.Planta
import kotlinx.coroutines.job

@Composable
fun AddPlantaAlertDialog(
    openDialog: Boolean,
    closeDialog: () -> Unit,
    addPlanta: (planta: Planta) -> Unit,
    loginId: Int
) {
    if (openDialog) {
        var nombre by remember { mutableStateOf(NO_VALUE) }
        var especie by remember { mutableStateOf(NO_VALUE) }
        var sensorHumedad by remember { mutableStateOf(NO_VALUE) }
        var sensorTemperatura by remember { mutableStateOf(NO_VALUE) }
        var imagen by remember { mutableStateOf(NO_VALUE) }
        var estado by remember { mutableStateOf(NO_VALUE) }
        var user_planta_id by remember {
            mutableStateOf(loginId)
        }
        val focusRequester = FocusRequester()

        AlertDialog(
            onDismissRequest = { closeDialog },
            title = {
                Text(
                    ADD_PLANTA, textAlign = TextAlign.Center,fontSize = 15.sp,
                )


            },

            text = {

                Column() {

                    TextField(
                        value = nombre,
                        onValueChange = { nombre = it },
                        placeholder = {
                            Text(NOMBRE)
                        },
                        singleLine = true
                    )

                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        value = especie,
                        onValueChange = { especie = it },
                        placeholder = {
                            Text(ESPECIE)
                        },
                        singleLine = true

                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        value = sensorHumedad,
                        onValueChange = { sensorHumedad = it },
                        placeholder = {
                            Text(SENSOR_HUMEDAD)
                        },
                        singleLine = true
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        value = sensorTemperatura,
                        onValueChange = { sensorTemperatura = it },
                        placeholder = {
                            Text(SENSOR_TEMPERATURA)
                        },
                        singleLine = true
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        value = imagen,
                        onValueChange = { imagen = it },
                        placeholder = {
                            Text(IMAGEN)
                        },
                        singleLine = true
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        value = estado,
                        onValueChange = { estado = it },
                        placeholder = {
                            Text(ESTADO)
                        },
                        singleLine = true
                    )


                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        closeDialog()
                        val planta = Planta(
                            0,
                            nombre,
                            especie,
                            sensorHumedad,
                            sensorTemperatura,
                            imagen,
                            estado,
                            user_planta_id
                        )
                        addPlanta(planta)
                    }) {
                    Text(ADD)
                }
            },
            dismissButton = {
                TextButton(
                    onClick = closeDialog
                ) {
                    Text(DISMISS)
                }
            }

        )
    }
}