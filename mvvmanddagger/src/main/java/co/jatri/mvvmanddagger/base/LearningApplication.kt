package co.jatri.mvvmanddagger.base

import android.app.Application
import co.jatri.mvvmanddagger.di.DaggerApplicationComponent
import co.jatri.mvvmanddagger.utils.SharedPrefHelper
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class LearningApplication : Application(), HasAndroidInjector {

    private lateinit var helper: SharedPrefHelper
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()
        helper = SharedPrefHelper(this)
        DaggerApplicationComponent.builder().application(this).build().inject(this)
    }

}