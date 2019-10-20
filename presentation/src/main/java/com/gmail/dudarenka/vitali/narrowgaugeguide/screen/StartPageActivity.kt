package com.gmail.dudarenka.vitali.narrowgaugeguide.screen

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.gmail.dudarenka.vitali.narrowgaugeguide.R
import com.gmail.dudarenka.vitali.narrowgaugeguide.base.BaseMvvmActivity
import com.gmail.dudarenka.vitali.narrowgaugeguide.databinding.ActivityStartPageBinding

private const val ID_EXTRA = "ID_EXTRA"

class StartPageActivity : BaseMvvmActivity<StartPageViewModel, StartPageRouter, ActivityStartPageBinding>() {


    override fun provideRouter(): StartPageRouter {
        return StartPageRouter(this)
    }

    override fun provideViewModel(): StartPageViewModel {
        return ViewModelProviders.of(this).get(StartPageViewModel::class.java)
    }

    override fun provideLayoutId(): Int = R.layout.activity_start_page

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

}