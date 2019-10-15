package co.jatri.mvvmanddagger.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.jatri.mvvmanddagger.R
import co.jatri.mvvmanddagger.base.BaseActivity
import co.jatri.mvvmanddagger.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun layoutRes(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataBinding.tv.setOnClickListener { showToast(this,"this is main activity") }

    }
}
