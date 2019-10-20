package com.gmail.dudarenka.vitali.narrowgaugeguide.base

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.gmail.dudarenka.vitali.narrowgaugeguide.BR


abstract class BaseMvvmActivity<VM : BaseViewModel<R>, R : BaseRouter<*>, B : ViewDataBinding> : BaseActivity() {
    protected lateinit var viewModel: VM
    protected lateinit var binding: B
    public lateinit var router: R
    abstract fun provideViewModel(): VM
    abstract fun provideLayoutId(): Int
    abstract fun provideRouter(): R

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = provideViewModel()
        binding = DataBindingUtil.setContentView(this, provideLayoutId())
        binding.setVariable(BR.viewModel, viewModel)
        router = provideRouter()
    }

    override fun onResume() {
        super.onResume()
        viewModel.addRouter(router)
    }

    override fun onPause() {
        super.onPause()
        viewModel.removeRouter()
    }
}