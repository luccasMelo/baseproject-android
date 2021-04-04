package com.luccasmelo.baselibrary.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.luccasmelo.baselibrary.viewmodel.BaseViewModel


abstract class BaseActivity<V : BaseViewModel, B : ViewDataBinding>(val layoutResource: Int) :
    AppCompatActivity() {

    lateinit var binding: B
    lateinit var viewModel: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, layoutResource)
        viewModel = ViewModelProvider(this).get(viewModel::class.java)

        onCreate()
    }

    abstract fun onCreate()


}