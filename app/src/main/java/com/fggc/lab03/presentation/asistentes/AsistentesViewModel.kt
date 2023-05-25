package com.fggc.lab03.presentation.asistentes

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fggc.lab03.core.Constants.Companion.NO_VALUE
import com.fggc.lab03.domain.model.Asistente
import com.fggc.lab03.domain.repository.AsistenteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class
AsistentesViewModel @Inject constructor(
    private val repo: AsistenteRepository
): ViewModel() {

    var asistente by mutableStateOf(Asistente(0, NO_VALUE, NO_VALUE, NO_VALUE, NO_VALUE, NO_VALUE, NO_VALUE, NO_VALUE))
    var openDialog by mutableStateOf(false)
    val asistentes = repo.getAsistentesFromRoom()
    fun addAsistente(asistente: Asistente)= viewModelScope.launch(Dispatchers.IO)
    {
        repo.addAsistenteToRoom(asistente)
    }
    fun closeDialog(){
        openDialog = false
    }
    fun openDialog(){
        openDialog = true
    }
    fun deleteAsistente(asistente: Asistente) =
        viewModelScope.launch(Dispatchers.IO){
            repo.deleteAsistenteFromRoom(asistente)
        }

    fun updateNombre(nombre: String){
        this.asistente = this.asistente.copy(
            nombre = nombre
        )
    }

    fun updateApellido(apellido: String){
        asistente = asistente.copy(
            apellido = apellido
        )
    }

    fun updateFechaInscripcion(fechaInscripcion: String){
        asistente = asistente.copy(
            fechaInscripcion = fechaInscripcion
        )
    }

    fun updateTipoSangre(tipoSangre: String){
        asistente = asistente.copy(
            tipoSangre = tipoSangre
        )
    }

    fun updateTelefono(telefono: String){
        asistente = asistente.copy(
            telefono = telefono
        )
    }

    fun updateCorreo(correo: String){
        asistente = asistente.copy(
            correo = correo
        )
    }

    fun updateMontoPagado(montoPagado: String){
        asistente = asistente.copy(
            montoPagado = montoPagado
        )
    }

    fun updateAsistente(asistente: Asistente) =
        viewModelScope.launch(Dispatchers.IO){
            repo.updateAsistenteInRoom(asistente)
        }

    fun getAsistente(id: Int) = viewModelScope.launch(
        Dispatchers.IO
    ) {
        asistente = repo.getAsistenteFromRoom(id)
    }
}