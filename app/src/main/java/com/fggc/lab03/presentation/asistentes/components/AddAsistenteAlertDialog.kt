package com.fggc.lab03.presentation.asistentes.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.unit.dp
import com.fggc.lab03.core.Constants.Companion.ADD
import com.fggc.lab03.core.Constants.Companion.ADD_ASISTENTE
import com.fggc.lab03.core.Constants.Companion.NOMBRE
import com.fggc.lab03.core.Constants.Companion.DISMISS
import com.fggc.lab03.core.Constants.Companion.NO_VALUE
import com.fggc.lab03.core.Constants.Companion.APELLIDO
import com.fggc.lab03.core.Constants.Companion.CORREO
import com.fggc.lab03.core.Constants.Companion.FECHA_INSCRIPCION
import com.fggc.lab03.core.Constants.Companion.MONTO_PAGADO
import com.fggc.lab03.core.Constants.Companion.TELEFONO
import com.fggc.lab03.core.Constants.Companion.TIPO_SANGRE
import com.fggc.lab03.domain.model.Asistente
import kotlinx.coroutines.job

@Composable
fun AddAsistenteAlertDialog(
    openDialog: Boolean,
    closeDialog: () -> Unit,
    addAsistente: (asistente: Asistente) -> Unit
){
    if (openDialog){
        var nombre by remember { mutableStateOf(NO_VALUE)}
        var apellido by remember { mutableStateOf(NO_VALUE)}
        var fecha_inscripcion by remember { mutableStateOf(NO_VALUE)}
        var tipo_sangre by remember { mutableStateOf(NO_VALUE)}
        var telefono by remember { mutableStateOf(NO_VALUE)}
        var correo by remember { mutableStateOf(NO_VALUE)}
        var monto_pagado by remember { mutableStateOf(NO_VALUE)}
        val focusRequester = FocusRequester()

        AlertDialog(
            onDismissRequest = { closeDialog },
            title = {
                Text(ADD_ASISTENTE)
            },
            text = {
                Column() {
                    TextField(
                        value = nombre,
                        onValueChange = {nombre = it},
                        placeholder = {
                            Text(NOMBRE)
                        },
                        modifier = Modifier.focusRequester(focusRequester)
                    )
                    LaunchedEffect(Unit){
                        coroutineContext.job.invokeOnCompletion {
                            focusRequester.requestFocus()
                        }
                    }
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        value = apellido,
                        onValueChange = {apellido = it},
                        placeholder = {
                            Text(APELLIDO)
                        }
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        value = fecha_inscripcion,
                        onValueChange = {fecha_inscripcion = it},
                        placeholder = {
                            Text(FECHA_INSCRIPCION)
                        }
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        value = tipo_sangre,
                        onValueChange = {tipo_sangre = it},
                        placeholder = {
                            Text(TIPO_SANGRE)
                        }
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        value = telefono,
                        onValueChange = {telefono = it},
                        placeholder = {
                            Text(TELEFONO)
                        }
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        value = correo,
                        onValueChange = {correo = it},
                        placeholder = {
                            Text(CORREO)
                        }
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        value = monto_pagado,
                        onValueChange = {monto_pagado = it},
                        placeholder = {
                            Text(MONTO_PAGADO)
                        }
                    )
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        closeDialog()
                        val asistente = Asistente(0,nombre,apellido, fecha_inscripcion, tipo_sangre, telefono, correo, monto_pagado)
                        addAsistente(asistente)
                    }) {
                    Text(ADD)
                }
            },
            dismissButton = {
                TextButton(
                    onClick = closeDialog) {
                    Text(DISMISS)
                }
            }

        )
    }
}