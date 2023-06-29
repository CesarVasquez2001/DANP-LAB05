package com.fggc.lab03.presentation.sensor

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amplifyframework.core.Amplify
import com.amplifyframework.core.model.query.Page
import com.amplifyframework.core.model.query.Where
import com.amplifyframework.core.model.temporal.Temporal
import com.amplifyframework.datastore.generated.model.Priority
import com.amplifyframework.datastore.generated.model.Todo
import com.fggc.lab03.domain.repository.ReporteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Date
import java.util.TimeZone
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class
SensorViewModel @Inject constructor(
    private val repo: ReporteRepository
) : ViewModel() {


    fun querySensorData(){
        Amplify.DataStore.query(Todo::class.java,
            Where.matchesAll().paginated(Page.startingAt(0).withLimit(100)),
            { todos ->
                while (todos.hasNext()) {
                    val todo = todos.next()
                    Log.i("MyAmplifyApp", "Title: ${todo.name}")
                }
            },
            { Log.e("MyAmplifyApp", "Query failed", it) }
        )
    }

    val date = Date()
    val offsetMillis = TimeZone.getDefault().getOffset(date.time).toLong()
    val offsetSeconds = TimeUnit.MILLISECONDS.toSeconds(offsetMillis).toInt()
    val temporalDateTime = Temporal.DateTime(date, offsetSeconds)
    val item = Todo.builder()
        .name("Finish quarterly taxes")
        .priority(Priority.HIGH)
        .completedAt(temporalDateTime)
        .build()

    fun addTodo(){
        Amplify.DataStore.save(item,
            { Log.i("Tutorial", "Saved item: ${item.name}") },
            { Log.e("Tutorial", "Could not save item to DataStore", it) }
        )
    }

    var openDialog by mutableStateOf(false)
    val reportes = repo.getReportesFromRoom()


    var reportesUsers = repo.getUsersWithPosts(0)


    fun closeDialog() {
        openDialog = false
    }

    fun openDialog() {
        openDialog = true
    }

    fun getPostswithUser(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        reportesUsers = repo.getUsersWithPosts(id)
    }

}