package com.example.space__chat.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.space__chat.presentation.bottom_user_screen.BottomUserFragment
import com.example.space__chat.presentation.top_user_screen.TopUserFragment
import com.example.space__chat.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initFragments()

    }

    private fun initFragments() {
        supportFragmentManager.beginTransaction().apply {
            add(binding.topUserFragment.id, TopUserFragment())
            add(binding.bottomUserFragment.id, BottomUserFragment())
            commit()
        }

    }

}