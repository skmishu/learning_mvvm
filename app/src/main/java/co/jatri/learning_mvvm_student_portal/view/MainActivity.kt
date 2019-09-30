package co.jatri.learning_mvvm_student_portal.view

import android.os.Bundle
import android.view.View

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import co.jatri.learning_mvvm_student_portal.R
import co.jatri.learning_mvvm_student_portal.databinding.ActivityMainBinding
import co.jatri.learning_mvvm_student_portal.view_model.UserViewModel

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private var userViewModel: UserViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //        binding view with data binding.
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //        adding viewModelProvider to MainActivity
        userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)

        init()
    }

    private fun init() {
        userViewModel?.userLiveData()?.observe(this, Observer { binding?.user = it })
    }

    fun onClickVerify(view: View) {
        //        observe on action
        /*        userViewModel.locateUserNetworkProvider(binding.etPhone.getText().toString(),
                binding.etName.getText().toString()).observe(this,
                result -> binding.setUser(result));*/

        //      execute the action only.
        userViewModel!!.locateUserNetworkProvider(binding!!.etPhone.text.toString(),
                binding!!.etName.text.toString())
    }
}
