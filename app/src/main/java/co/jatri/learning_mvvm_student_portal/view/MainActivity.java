package co.jatri.learning_mvvm_student_portal.view;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import co.jatri.learning_mvvm_student_portal.R;
import co.jatri.learning_mvvm_student_portal.databinding.ActivityMainBinding;
import co.jatri.learning_mvvm_student_portal.view_model.UserViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        binding view with data binding.
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        adding viewModelProvider to MainActivity
        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);

        init();
    }

    private void init() {
        userViewModel.userLiveData().observe(this, userModel -> binding.setUser(userModel));
    }

    public void onClickVerify(View view) {
//        observe on action
/*        userViewModel.locateUserNetworkProvider(binding.etPhone.getText().toString(),
                binding.etName.getText().toString()).observe(this,
                result -> binding.setUser(result));*/

//      execute the action only.
        userViewModel.locateUserNetworkProvider(binding.etPhone.getText().toString(),
                binding.etName.getText().toString());
    }
}
