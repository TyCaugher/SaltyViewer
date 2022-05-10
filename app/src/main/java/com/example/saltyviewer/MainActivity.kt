package com.example.saltyviewer

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.saltyviewer.api.Post
import com.example.saltyviewer.api.e6Api
import com.example.saltyviewer.ui.theme.SaltyViewerTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    val baseUrl = "https://e621.net/"
    fun getInstance() : Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

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
        val e6Api = RetrofitHelper.getInstance().create(e6Api::class.java)
        GlobalScope.launch {
            val result = e6Api.getPosts()
            if (result != null)
                Log.d("API", result.body().toString())
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

suspend fun getApiPosts() {

}

@Composable
fun TestPostList() {
    // We save the scrolling position with this state that can also
    // be used to programmatically scroll the list
    val scrollState = rememberLazyListState()



    LazyColumn(state = scrollState) {
        items(100) {
            Text("Item #$it")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppLayoutPreview() {
    SaltyViewerTheme {
        AppLayout()
    }
}