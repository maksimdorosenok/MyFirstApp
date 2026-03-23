package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.example.myfirstapp.databinding.ActivityMainBinding
import com.example.myfirstapp.dto.Post
import com.example.myfirstapp.util.FormatUtils
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var post: Post

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        post = Post(
            id = 1,
            author = "Нетология. Университет интернет-профессий",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов.",
            published = "21 мая в 18:36",
            likedByMe = false,
            likes = 999,
            shares = 25,
            views = 5700
        )

        bindPost(post)

        setupClickListeners()
    }

    private fun bindPost(post: Post) {
        binding.apply {
            author.text = post.author
            published.text = post.published
            content.text = post.content

            likeCount.text = FormatUtils.formatCount(post.likes)
            shareCount.text = FormatUtils.formatCount(post.shares)
            viewsCount.text = FormatUtils.formatCount(post.views)

            if (post.likedByMe) {
                like.setImageResource(R.drawable.ic_favorite)
            } else {
                like.setImageResource(R.drawable.ic_favorite_border)
            }

            linkTitle.text = "Новая Нетология: 4 уровня карьеры"
            linkUrl.text = "netology.ru"
        }
    }

    private fun setupClickListeners() {
        binding.apply {
            like.setOnClickListener {
                post = post.copy(
                    likedByMe = !post.likedByMe,
                    likes = if (post.likedByMe) post.likes - 1 else post.likes + 1
                )

                bindPost(post)

                Toast.makeText(
                    this@MainActivity,
                    if (post.likedByMe) "Лайк поставлен" else "Лайк убран",
                    Toast.LENGTH_SHORT
                ).show()
            }

            share.setOnClickListener {
                post = post.copy(
                    shares = post.shares + 1
                )

                bindPost(post)

                Toast.makeText(this@MainActivity, "Репост +1", Toast.LENGTH_SHORT).show()
            }

            menu.setOnClickListener {
                Toast.makeText(this@MainActivity, "Меню поста", Toast.LENGTH_SHORT).show()
            }

            avatar.setOnClickListener {
                Toast.makeText(this@MainActivity, "Профиль автора", Toast.LENGTH_SHORT).show()
            }

            root.setOnClickListener {
                println("CLICK: корневой layout")
                Toast.makeText(this@MainActivity, "Клик по фону", Toast.LENGTH_SHORT).show()
            }
        }
    }



}