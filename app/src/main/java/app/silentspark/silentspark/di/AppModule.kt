package app.silentspark.silentspark.di

import app.silentspark.silentspark.data.Repository
import app.silentspark.silentspark.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val AppModule = module {
    single { Repository() }
    viewModel {HomeViewModel(get()) }
}