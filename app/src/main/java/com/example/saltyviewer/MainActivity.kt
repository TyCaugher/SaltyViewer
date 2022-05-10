package com.example.saltyviewer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.saltyviewer.ui.theme.SaltyViewerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SaltyViewerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AppLayout()
                }
            }
        }
    }
}

@Composable
fun AppLayout() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "SaltyViewer")
                },
                actions = {
                    // Icons and stuff here
                }
            )
        }
    ) { innerPadding ->
        BodyContent(
            Modifier
                .padding(innerPadding)
                .padding(8.dp))
    }
}

@Composable
fun BodyContent(padding: Modifier) {

}


@Composable
fun GridImageList() {

}

@Preview(showBackground = true)
@Composable
fun AppLayoutPreview() {
    SaltyViewerTheme {
        AppLayout()
    }
}