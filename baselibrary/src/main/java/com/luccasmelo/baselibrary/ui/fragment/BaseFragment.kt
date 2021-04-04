package com.luccasmelo.baselibrary.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.luccasmelo.baselibrary.viewmodel.BaseViewModel
import com.luccasmelo.baselibrary.ui.activity.BaseActivity


abstract class BaseFragment<A : BaseActivity<V, AB>, V : BaseViewModel, B : ViewDataBinding, AB : ViewDataBinding>(
    val layoutResource: Int
) : Fragment() {

    lateinit var baseActivity: A
    lateinit var binding: B
    lateinit var viewModel: V

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        baseActivity = activity as A
        viewModel = baseActivity.viewModel
        binding = DataBindingUtil.inflate(inflater,layoutResource, container,false)


        return binding.root

    }
}