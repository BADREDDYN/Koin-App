package com.koin.testapp.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import com.koin.testapp.R
import com.koin.testapp.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collectLatest
import org.koin.android.ext.android.get

class MainActivity : AppCompatActivity() {

    //Binding
    private lateinit var binding:ActivityMainBinding

    //ViewModel
    private val vm:MainViewModel = get()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vm.doSomething()
        lifecycleScope.launchWhenStarted {
            vm.doSomeThingMutableStateFlow.collectLatest {
                it.shortSnackBar()
            }
        }


    }

    private fun String.shortSnackBar() {
        Snackbar.make(binding.root, this, Snackbar.LENGTH_SHORT).show()
    }
}