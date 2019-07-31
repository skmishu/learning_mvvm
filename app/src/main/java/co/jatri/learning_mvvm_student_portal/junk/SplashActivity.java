package co.jatri.learning_mvvm_student_portal.junk;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.iid.FirebaseInstanceId;

import co.jatri.learning_mvvm_student_portal.R;
import co.jatri.learning_mvvm_student_portal.view.MainActivity;

public class SplashActivity extends AppCompatActivity {

    private static final String TAG = "splash_screen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Log.e(TAG, "onCreate: " + FirebaseInstanceId.getInstance().getToken());
        startActivity(new Intent(this, MainActivity.class));
    }

}
