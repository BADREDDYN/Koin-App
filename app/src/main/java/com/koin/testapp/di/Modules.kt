package com.koin.testapp.di

import com.koin.testapp.repositories.MyRepositoryImpl
import com.koin.testapp.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { MyRepositoryImpl() }
}

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}