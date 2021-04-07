package com.luccasmelo.baselibrary.viewmodel

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController

open class BaseViewModel : ViewModel() {
    lateinit var navController: NavController

    fun onCreate(navController: NavController) {
        this.navController = navController
    }

}