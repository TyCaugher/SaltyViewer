package com.example.saltyviewer

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.saltyviewer.api.Post
import com.example.saltyviewer.api.e6Api

/*
* Implementing paging for infinite scrolling between post pages.
*/

class PostSource : PagingSource<Int, Post>() {
    override fun getRefreshKey(state: PagingState<Int, Post>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Post> {
        return try {
            val nextPage = params.key ?: 1
            val postList = e6Api.getPosts(page = nextPage)

        }
    }

}