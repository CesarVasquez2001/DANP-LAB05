package com.fggc.lab03.presentation.reportes.components

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.fggc.lab03.core.Constants.Companion.DELETE_PLANTA

@Composable
fun DeleteIcon(
    deletePlanta: () -> Unit
) {
    var showDialog by remember { mutableStateOf(false) }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text(text = "Eliminar Confirmación") },
            text = { Text(text = "¿Estás seguro de que quieres eliminar esta planta?") },
            confirmButton = {
                Button(
                    onClick = {
                        deletePlanta()
                        showDialog = false
                    }
                ) {
                    Text(text = "Eliminar")
                }
            },
            dismissButton = {
                Button(onClick = { showDialog = false }) {
                    Text(text = "Cancelar")
                }
            }
        )
    }

    IconButton(onClick = { showDialog = true }) {
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = "Delete"
        )
    }
}