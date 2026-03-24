package com.example.myfirstapp.myfirstapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.myfirstapp.dto.Post
import com.example.myfirstapp.repository.PostRepository
import com.example.myfirstapp.repository.PostRepositoryInMemoryImpl

class PostViewModel : ViewModel() {

    // Создаем экземпляр репозитория
    private val repository: PostRepository = PostRepositoryInMemoryImpl()

    // Данные, доступные для наблюдения
    val data: LiveData<Post> = repository.get()

    // Методы для вызова из Activity
    fun like() = repository.like()
    fun share() = repository.share()
    fun increaseViews() = repository.increaseViews()


        init {
            println("ViewModel: created")
        }

        override fun onCleared() {
            super.onCleared()
            println("ViewModel: cleared")
        }


}
