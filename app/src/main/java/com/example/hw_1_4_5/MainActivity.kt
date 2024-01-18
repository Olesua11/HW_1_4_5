package com.example.hw1_4_2


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hw1_4_5.ui.home.HomeFragment
import com.example.hw_1_4_5.R
import com.example.hw_1_4_5.TaskUpdateListener
import com.example.hw_1_4_5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), TaskUpdateListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun updateTask(position: Int, updatedTask: String) {
        val homeFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main)
        if (homeFragment is HomeFragment) {
            homeFragment.updateTask(position, updatedTask)
        }
    }
}
