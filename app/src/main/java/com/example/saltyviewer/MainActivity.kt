package com.example.saltyviewer

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
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

        setContent {
            SaltyViewerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    PostView()

                }
            }
        }
    }
}

@Composable
fun PostView() {
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
        })
}

@Composable
fun ImageGridView(vm: PostViewModel){

    LaunchedEffect(Unit, block = {
        vm.getPostList()
    })

    if (vm.errorMessage.isEmpty()) {
        Column {
            for(post in vm.postList) {
                Text(text = post.id.toString())
                ImageItem(url = post.sample.url)
            }
        }
        Log.d("API", vm.postList.toString())
    }
    else {
        Text(vm.errorMessage)
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
        placeHolder = R.drawable.ic_baseline_broken_image_24
    )
}


@Preview(showBackground = true)
@Composable
fun AppLayoutPreview() {
    val vm = PostViewModel()
    SaltyViewerTheme {
        PostView()
    }
}


@Preview(showBackground = true)
@Composable
fun ImageItemPreview() {
    SaltyViewerTheme {
        ImageItem("https://static1.e621.net/data/c7/3e/c73e288f4ee599be8e0c88ca005ada3d.png")
    }
}