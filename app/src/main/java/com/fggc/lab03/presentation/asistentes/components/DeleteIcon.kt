package com.fggc.lab03.presentation.asistentes.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import com.fggc.lab03.core.Constants.Companion.DELETE_ASISTENTE

@Composable
fun DeleteIcon(
    deleteAsistente: () -> Unit
){
    IconButton(onClick =  deleteAsistente ) {
        Icon(imageVector = Icons.Default.Delete,
            contentDescription = DELETE_ASISTENTE)
    }
}