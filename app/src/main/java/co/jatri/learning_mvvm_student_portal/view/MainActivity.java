package co.jatri.learning_mvvm_student_portal.view;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import co.jatri.learning_mvvm_student_portal.R;
import co.jatri.learning_mvvm_student_portal.view_model.UserViewModel;

public class MainActivity extends AppCompatActivity {

    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);


    }

    public void onClickVerify(View view) {
        EditText etName = findViewById(R.id.etName), etPhone = findViewById(R.id.etPhone);
        userViewModel.locateUserNetworkProvider(etPhone.getText().toString(),
                etName.getText().toString()).observe(this,
                result -> Toast.makeText(this,
                        result.getNetworkProvider(),
                        Toast.LENGTH_LONG).show());
    }
}
