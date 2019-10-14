package co.jatri.mvvmanddagger.base

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import co.jatri.mvvmanddagger.utils.SharedPrefHelper
import javax.inject.Inject

class BaseActivity<D : ViewDataBinding> : AppCompatActivity() {

    @Inject
    lateinit var applicationContext: Application

    @Inject
    lateinit var helper: SharedPrefHelper
    protected lateinit var dataBinding:D

}