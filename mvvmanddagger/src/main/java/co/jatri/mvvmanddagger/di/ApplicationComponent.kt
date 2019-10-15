package co.jatri.mvvmanddagger.di

import android.app.Application
import co.jatri.mvvmanddagger.base.LearningApplication
import co.jatri.mvvmanddagger.utils.SharedPrefHelper
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
        modules = [
            ActivityModule::class,
            AndroidInjectionModule::class,
            SharedPrefHelper::class
        ]
)
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent

    }

    fun inject(application: LearningApplication)
}