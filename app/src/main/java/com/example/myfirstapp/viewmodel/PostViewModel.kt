package com.example.myfirstapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.myfirstapp.dto.Post
import com.example.myfirstapp.repository.PostRepository
import com.example.myfirstapp.repository.PostRepositoryInMemoryImpl

class PostViewModel : ViewModel() {

    private val repository: PostRepository = PostRepositoryInMemoryImpl()

    val data: LiveData<List<Post>> = repository.getAll()

    fun likeById(id: Long) = repository.likeById(id)

    fun shareById(id: Long) = repository.shareById(id)

    fun increaseViews(id: Long) = repository.increaseViews(id)
}
