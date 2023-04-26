package com.example.space__chat.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.example.space__chat.Presentation.ui.ChatUsersFragment
import com.example.space__chat.Presentation.model.UserTypeEnum
import com.example.space__chat.R
import com.example.space__chat.databinding.ActivityMainBinding

class MainScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initFragments(savedInstanceState)
        switchListener()
    }

    private fun initFragments(savedInstanceState: Bundle?) {
        supportFragmentManager.beginTransaction().apply {
            if (savedInstanceState == null) {
                add(binding.topUserFragment.id, ChatUsersFragment(), UserTypeEnum.UserSender.name)
                add(
                    binding.bottomUserFragment.id,
                    ChatUsersFragment(),
                    UserTypeEnum.UserReceiver.name
                )
            } else {
                replace(
                    binding.topUserFragment.id,
                    ChatUsersFragment(),
                    UserTypeEnum.UserSender.name
                )
                replace(
                    binding.bottomUserFragment.id,
                    ChatUsersFragment(),
                    UserTypeEnum.UserReceiver.name
                )
            }.commit()
        }
    }

    private fun switchListener() {
        binding.switchBTN?.setOnCheckedChangeListener { _, isChecked ->
            switchTheme(isChecked)
        }
    }

    private fun switchTheme(isNightModeOn: Boolean) {
        AppCompatDelegate.setDefaultNightMode(
            (if (isNightModeOn) {
                binding.switchBTN?.setBackgroundResource(R.drawable.ic_switch_dark_bckg)
                AppCompatDelegate.MODE_NIGHT_YES
            } else {
                AppCompatDelegate.MODE_NIGHT_NO
            })
        )
    }
}