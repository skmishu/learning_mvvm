package co.jatri.learning_mvvm_student_portal.junk;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import java.util.Objects;

import co.jatri.learning_mvvm_student_portal.view.MainActivity;
import co.jatri.learning_mvvm_student_portal.R;

public class SplashActivity extends AppCompatActivity {

    private static final String TAG = "splash_screen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "getInstanceId failed", task.getException());
                            return;
                        }

                        // Get new Instance ID token
                        String token = Objects.requireNonNull(task.getResult()).getToken();

                        // Log and toast
                        String msg = String.format(String.valueOf(R.string.msg_token_fmt), token);
                        Log.d(TAG, msg);
                        Toast.makeText(SplashActivity.this, msg, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    }
                });
    }

    /**
     * Called if InstanceID token is updated. This may occur if the security of
     * the previous token had been compromised. Note that this is called when the InstanceID token
     * is initially generated so this is where you would retrieve the token.
     */
    public void onNewToken(String token) {
        Log.d(TAG, "Refreshed token: " + token);

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        sendRegistrationToServer(token);
    }

    private void sendRegistrationToServer(String token) {
        Log.e(TAG, "sendRegistrationToServer: " + token);
    }
}
