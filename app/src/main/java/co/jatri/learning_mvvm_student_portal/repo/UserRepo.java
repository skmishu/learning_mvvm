package co.jatri.learning_mvvm_student_portal.repo;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import co.jatri.learning_mvvm_student_portal.model.UserModel;

import static android.content.ContentValues.TAG;

public class UserRepo {

    private MutableLiveData<UserModel> userLivedata = new MutableLiveData<>();

    public UserRepo() {
    }

    //    this method just validates an user phone network provider
    public LiveData<UserModel> networkProviderLocator(String phone, String name) {
        Log.e(TAG, "networkProviderLocator: " + phone.substring(0, 3));
        if (phone.substring(0, 3).equals("018"))
            userLivedata.setValue(new UserModel(name, phone, "1", "robi"));
        else if (phone.startsWith("017"))
            userLivedata.setValue(new UserModel(name, phone, "2", "gp"));
        else userLivedata.setValue(new UserModel(name, phone, "0", "unknown"));
        return userLivedata;
    }

}
