package co.jatri.learning_mvvm_student_portal.repo

import android.util.Log

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import co.jatri.learning_mvvm_student_portal.model.UserModel

import android.content.ContentValues.TAG

class UserRepo {

    private val userLiveData = MutableLiveData<UserModel>()

    //    this method just validates an user phone network provider
    fun networkProviderLocator(phone: String, name: String): LiveData<UserModel> {
        var phone = phone
        if (phone.substring(0, 3).contains("+88")) phone = phone.substring(3)
        Log.e(TAG, "networkProviderLocator: " + phone.substring(0, 3))
        if (phone.substring(0, 3) == "018")
            userLiveData.setValue(UserModel(name, phone, "1", "robi"))
        else if (phone.startsWith("017"))
            userLiveData.setValue(UserModel(name, phone, "2", "gp"))
        else if (phone.startsWith("015"))
            userLiveData.setValue(UserModel(name, phone, "2", "teletalk"))
        else if (phone.startsWith("019"))
            userLiveData.setValue(UserModel(name, phone, "2", "banglalink"))
        else
            userLiveData.setValue(UserModel(name, phone, "0", "unknown"))
        return userLiveData
    }

    fun userLiveRepo(): LiveData<UserModel> {
        return userLiveData
    }

}
