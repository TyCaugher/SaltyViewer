package com.example.saltyviewer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.compose.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainViewModel : MainViewModel by viewModels()

        setContent {
            AppTheme {
                // A surface container using the 'background' color from the theme
                MainScreen(mainViewModel = mainViewModel)
            }
        }
    }
}

