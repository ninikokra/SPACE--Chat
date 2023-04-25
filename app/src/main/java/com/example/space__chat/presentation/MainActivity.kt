package com.example.space__chat.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.space__chat.Presentation.chat_screen.ChatUsersFragment
import com.example.space__chat.Presentation.utils.UserTypeEnum
import com.example.space__chat.R
import com.example.space__chat.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initFragments()
        listeners()

    }

    private fun initFragments() {
        supportFragmentManager.beginTransaction().apply {
            binding.topUserFragment?.let {
                replace(it.id, ChatUsersFragment(), UserTypeEnum.UserSender.name)
            }
            binding.bottomUserFragment?.let {
                replace(it.id, ChatUsersFragment(), UserTypeEnum.UserReceiver.name)
                    .commit()
            }
        }
    }

    private fun listeners() {
        binding.dayNightSwitchBTN.setOnClickListener {
            onSwitchClick(it)
        }
        binding.nightDaySwitcherBTN?.setOnClickListener {
            onSwitchClick(it)
        }
    }

    private fun onSwitchClick(view: View) {
        when (view.id) {
            R.id.dayNightSwitchBTN -> {
                binding.activityMainLayout.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.dark_01_midnight_blue
                    )
                )
                binding.dayNightSwitchBTN.visibility = View.GONE
                binding.nightDaySwitcherBTN?.visibility = View.VISIBLE
                val topFragment =
                    supportFragmentManager.findFragmentById(R.id.topUserFragment) as ChatUsersFragment
                val bottomFragment =
                    supportFragmentManager.findFragmentById(R.id.bottomUserFragment) as ChatUsersFragment
                topFragment.updateTextColor(R.color.neutral_06_white)
                bottomFragment.updateTextColor(R.color.neutral_06_white)
            }

            R.id.nightDaySwitcherBTN -> {
                binding.activityMainLayout.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.neutral_06_white
                    )
                )
                binding.dayNightSwitchBTN.visibility = View.VISIBLE
                binding.nightDaySwitcherBTN?.visibility = View.GONE
                val topFragment =
                    supportFragmentManager.findFragmentById(R.id.topUserFragment) as ChatUsersFragment
                val bottomFragment =
                    supportFragmentManager.findFragmentById(R.id.bottomUserFragment) as ChatUsersFragment
                topFragment.updateTextColor(R.color.neutral_01_great_dark_grey)
                bottomFragment.updateTextColor(R.color.neutral_01_great_dark_grey)
            }
        }
    }
}