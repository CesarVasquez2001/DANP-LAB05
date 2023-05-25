package com.fggc.lab03.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.fggc.lab03.navigation.NavGraph
import com.fggc.lab03.ui.theme.AsistenteCrudTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AsistenteCrudTheme {
                // A surface container using the 'background' color from the theme
                NavGraph(navController = rememberNavController())
            }
        }
    }
}

