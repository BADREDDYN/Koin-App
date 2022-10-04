package com.koin.testapp.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.koin.testapp.repositories.MyRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val myRepositoryImpl: MyRepositoryImpl
) : ViewModel() {

    private val _doSomeThingMutableStateFlow = MutableStateFlow("")
    val doSomeThingMutableStateFlow = _doSomeThingMutableStateFlow

    fun doSomething() {
        viewModelScope.launch {
            _doSomeThingMutableStateFlow.value = myRepositoryImpl.doSomething()
        }
    }

}