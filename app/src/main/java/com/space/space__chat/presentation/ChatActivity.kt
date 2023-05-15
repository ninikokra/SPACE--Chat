package com.space.space__chat.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.space.space__chat.R
import com.space.space__chat.databinding.ActivityChatBinding
import com.space.space__chat.presentation.model.ThemeMode
import com.space.space__chat.presentation.ui.ChatUsersFragmentFirst
import com.space.space__chat.presentation.ui.ChatUsersFragmentSecond
import com.space.space__chat.utils.extensions.viewBinding

/**
 * [ChatActivity] is an activity class that represents the main screen of the chat feature.
 */

class ChatActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityChatBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            initFragments()
        }
        initSwitchListener()
    }

    private fun initFragments() {
        supportFragmentManager.beginTransaction().apply {
            replace(binding.topUserFragment.id, ChatUsersFragmentFirst())
            replace(binding.bottomUserFragment.id, ChatUsersFragmentSecond())
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