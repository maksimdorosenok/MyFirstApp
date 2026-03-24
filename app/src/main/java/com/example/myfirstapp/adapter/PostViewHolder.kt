package com.example.myfirstapp.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapp.R
import com.example.myfirstapp.databinding.CardPostBinding
import com.example.myfirstapp.dto.Post
import  com.example.myfirstapp.util.FormatUtils
import java.text.DecimalFormat

class PostViewHolder(
    private val binding: CardPostBinding,
    private val onLikeClickListener: (Post) -> Unit,
    private val onShareClickListener: (Post) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(post: Post) {
        binding.apply {
            author.text = post.author
            published.text = post.published
            content.text = post.content

            // Форматируем счетчики (можно вынести в отдельную функцию)
            likeCount.text = FormatUtils.formatCount(post.likes)
            shareCount.text = FormatUtils.formatCount(post.shares)
            viewsCount.text = FormatUtils.formatCount(post.views)

            // Устанавливаем иконку лайка
            if (post.likedByMe) {
                like.setImageResource(R.drawable.ic_favorite)
            } else {
                like.setImageResource(R.drawable.ic_favorite_border)
            }

            // Обработчики кликов
            like.setOnClickListener {
                onLikeClickListener(post)
            }

            share.setOnClickListener {
                onShareClickListener(post)
            }

            // Для исследования (можно оставить или убрать)
            menu.setOnClickListener {
                android.widget.Toast.makeText(
                    itemView.context,
                    "Меню поста ${post.id}",
                    android.widget.Toast.LENGTH_SHORT
                ).show()
            }

            avatar.setOnClickListener {
                android.widget.Toast.makeText(
                    itemView.context,
                    "Профиль автора ${post.author}",
                    android.widget.Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

}

