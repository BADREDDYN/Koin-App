package com.koin.testapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.koin.testapp.R
import com.koin.testapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //Binding
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}