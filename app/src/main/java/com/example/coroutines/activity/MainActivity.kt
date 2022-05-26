package com.example.coroutines.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.coroutines.databinding.ActivityMainBinding
import com.example.coroutines.viewmodel.UserViewModel

class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding

    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        initViews()
    }

    private fun initViews() {
        userViewModel.getUsers().observe(this) {
            binding.tvUser.text = it
        }

    }


}