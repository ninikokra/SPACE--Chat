package com.example.space__chat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.space__chat.Presentation.BottomUserScreen.BottomUserFragment
import com.example.space__chat.Presentation.TopUserScreen.TopUserFragment
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