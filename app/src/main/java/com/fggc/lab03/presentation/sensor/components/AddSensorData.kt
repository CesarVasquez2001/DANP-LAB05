package com.fggc.lab03.presentation.sensor.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import com.fggc.lab03.core.Constants

@Composable
fun AddSensorData(
    openDialog: Boolean,
    closeDialog: () -> Unit,
    addReporte: () -> Unit
) {
    if (openDialog) {

        AlertDialog(
            onDismissRequest = { closeDialog },
            title = {
                Text(Constants.ADD_PLANTA)
            },
            text = {
                Column() {

                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        closeDialog()
                        addReporte()
                    }) {
                    Text(Constants.ADD)
                }
            },
            dismissButton = {
                TextButton(
                    onClick = closeDialog
                ) {
                    Text(Constants.DISMISS)
                }
            }

        )
    }
}