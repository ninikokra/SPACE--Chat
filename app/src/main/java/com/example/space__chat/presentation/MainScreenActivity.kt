package com.example.space__chat.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.example.space__chat.Presentation.ui.ChatUsersFragment
import com.example.space__chat.Presentation.model.UserType
import com.example.space__chat.R
import com.example.space__chat.databinding.ActivityMainBinding

class MainScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initFragments()
        switchListener()
    }

    private fun initFragments() {
        supportFragmentManager.beginTransaction().apply {
            replace(binding.topUserFragment.id, ChatUsersFragment(), UserType.Sender.name)
            replace(binding.bottomUserFragment.id, ChatUsersFragment(), UserType.Receiver.name)
        }.commit()
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