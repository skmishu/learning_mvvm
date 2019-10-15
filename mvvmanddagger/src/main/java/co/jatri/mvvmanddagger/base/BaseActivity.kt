package co.jatri.mvvmanddagger.base

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import co.jatri.mvvmanddagger.utils.SharedPrefHelper
import com.google.android.material.snackbar.Snackbar
import dagger.android.AndroidInjection
import java.lang.ref.WeakReference
import javax.inject.Inject

abstract class BaseActivity<D : ViewDataBinding> : AppCompatActivity() {

    @Inject
    lateinit var applicationContext: Application

    @Inject
    lateinit var helper: SharedPrefHelper
    protected lateinit var dataBinding: D
    protected var activityContext: Activity? = null
    protected var weekActivityContext: WeakReference<Activity>? = null

    @LayoutRes
    protected abstract fun layoutRes(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, layoutRes())
        activityContext = this
        weekActivityContext = WeakReference(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        activityContext = null
        weekActivityContext = null
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    protected fun showSnackbar(message: String?) {
        Snackbar.make(findViewById(android.R.id.content), "" + message, Snackbar.LENGTH_LONG).show()
    }

    protected fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    protected fun showProgressBar(isLoading: Boolean,view: View){
        if (isLoading) {
            view.visibility = View.VISIBLE
            window.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
        } else {
            view.visibility = View.GONE
            window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }


}