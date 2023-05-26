package com.fggc.lab03.presentation.login
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fggc.lab03.core.Constants.Companion.NO_VALUE
import com.fggc.lab03.domain.model.User
import com.fggc.lab03.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class
LoginViewModel @Inject constructor(
    private val repo: UserRepository
) : ViewModel() {
    var user by mutableStateOf(User(0, NO_VALUE, NO_VALUE))
    val users = repo.getUsersFromRoom()
    var userFind by mutableStateOf(User(0, NO_VALUE, NO_VALUE))

    fun addUser(user: User) = viewModelScope.launch(Dispatchers.IO)
    {
        repo.addUserToRoom(user)
    }

    fun getUser(id: Int) = viewModelScope.launch(
        Dispatchers.IO
    ) {
        user = repo.getUserFromRoom(id)
    }

    fun getUserConfirm(email: String, password: String) = viewModelScope.launch(
        Dispatchers.IO
    ) {
        userFind = repo.getUserConfirm(email, password)
    }
}

