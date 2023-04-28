package com.example.space__chat.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.example.space__chat.presentation.model.ThemeMode
import com.example.space__chat.presentation.model.UserType
import com.example.space__chat.R
import com.example.space__chat.databinding.ActivityChatBinding
import com.example.space__chat.presentation.ui.ChatUsersFragment

class ChatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initFragments()
        initSwitchListener()
    }

    private fun initFragments() {
        supportFragmentManager.beginTransaction().apply {
            replace(binding.topUserFragment.id, ChatUsersFragment(), UserType.TOP_USER.name)
            replace(binding.bottomUserFragment.id, ChatUsersFragment(), UserType.BOTTOM_USER.name)
        }.commit()
    }

    private fun initSwitchListener() {
        binding.switchButton.setOnCheckedChangeListener { _, isChecked ->
            switchTheme(if (isChecked) ThemeMode.DARK else ThemeMode.LIGHT)
        }
    }

    private fun switchTheme(mode: ThemeMode) {
        when (mode) {
            ThemeMode.LIGHT -> {
                binding.switchButton.setBackgroundResource(R.drawable.bckg_switch_light)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
            ThemeMode.DARK -> {
                binding.switchButton.setBackgroundResource(R.drawable.bckg_switch_dark)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
        }
    }
}