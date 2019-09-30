package co.jatri.learning_mvvm_student_portal.view

import android.content.Intent
import android.os.Bundle
import android.util.Log

import androidx.appcompat.app.AppCompatActivity

import com.google.firebase.iid.FirebaseInstanceId

import co.jatri.learning_mvvm_student_portal.R
import co.jatri.learning_mvvm_student_portal.view.MainActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Log.e(TAG, "onCreate: " + FirebaseInstanceId.getInstance().token!!)
        startActivity(Intent(this, MainActivity::class.java))
    }

    companion object {

        private val TAG = "splash_screen"
    }

}
