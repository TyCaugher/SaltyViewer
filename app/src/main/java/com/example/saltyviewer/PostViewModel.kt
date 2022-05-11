package com.example.saltyviewer

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.saltyviewer.api.Post
import com.example.saltyviewer.api.e6Api
import kotlinx.coroutines.launch
import java.lang.Exception

class PostViewModel : ViewModel() {
    private val _postList = mutableStateListOf<Post>()
    var errorMessage: String by mutableStateOf("")

    val postList: List<Post>
        get() = _postList

    fun getPostList() {
        viewModelScope.launch {
            val e6ApiService = RetrofitHelper.getInstance().create(e6Api::class.java)
            try {
                val result = e6ApiService.getPosts()
                _postList.clear()
                _postList.addAll(e6ApiService.getPosts().body()!!.posts)
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}