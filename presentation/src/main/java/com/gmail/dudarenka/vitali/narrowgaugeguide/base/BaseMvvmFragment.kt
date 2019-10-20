package com.gmail.dudarenka.vitali.narrowgaugeguide.base


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.gmail.dudarenka.vitali.narrowgaugeguide.BR


abstract class BaseMvvmFragment<VM : BaseViewModel<R>, R : BaseRouter<*>, B : ViewDataBinding> :
    BaseFragment() {
    protected lateinit var viewModel: VM
    abstract fun provideViewModel(): VM
    abstract fun provideLayoutId(): Int
    protected lateinit var binding: B
    protected var router: R? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, provideLayoutId(), container, false)
        viewModel = provideViewModel()
        binding.setVariable(BR.viewModel, viewModel)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity is BaseMvvmActivity<*, *, *>) {
            router = (activity as BaseMvvmActivity<*, *, *>).router as R
        }
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