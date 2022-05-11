package com.example.saltyviewer

import android.graphics.drawable.VectorDrawable
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.saltyviewer.api.Post
import com.example.saltyviewer.api.e6Api
import com.example.saltyviewer.ui.theme.SaltyViewerTheme
import com.skydoves.landscapist.glide.GlideImage
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
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
        
        val vm = PostViewModel()

        setContent {
            SaltyViewerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    PostView(vm)

                }
            }
        }
    }
}

@Composable
fun PostView(vm: PostViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Text("SaltyViewer")
                    }
                })
        },
        content = {
            ImageGridView(vm = vm)
        })
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageGridView(vm: PostViewModel){
    
    LaunchedEffect(Unit, block = {
        vm.getPostList()
    })

    LazyVerticalGrid(
        cells = GridCells.Fixed(2)
    ) {
        items(vm.postList.size) { index -> 
            ImageItem(url = vm.postList[index].file.url)
        }
    }
}

@Composable
fun GridImageList() {
}

@Composable
fun ImageItem(url: String) {
    GlideImage(
        imageModel = url,
        contentScale = ContentScale.Crop,
        modifier = Modifier.height(200.dp),
    )
}


@Preview(showBackground = true)
@Composable
fun AppLayoutPreview() {
    val vm = PostViewModel()
    SaltyViewerTheme {
        PostView(vm)
    }
}


@Preview(showBackground = true)
@Composable
fun ImageItemPreview() {
    SaltyViewerTheme {
        ImageItem("https://static1.e621.net/data/c7/3e/c73e288f4ee599be8e0c88ca005ada3d.png")
    }
}