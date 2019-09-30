package co.jatri.learning_mvvm_student_portal.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

import co.jatri.learning_mvvm_student_portal.model.UserModel
import co.jatri.learning_mvvm_student_portal.repo.UserRepo

class UserViewModel : ViewModel() {

    private val userRepo: UserRepo = UserRepo()

    fun locateUserNetworkProvider(phone: String, name: String) {
        userRepo.networkProviderLocator(phone, name)
    }

    fun userLiveData(): LiveData<UserModel> {
        return userRepo.userLiveRepo()
    }

    fun vaildateMobileNumber(mobile: String, name: String): LiveData<String> {
        return Transformations.map(userRepo.networkProviderLocator(mobile, name)) { user ->
            val message: String
            if (user.phone!!.length == 11) {
                message = "valid"
            } else {
                message = "invalid"
            }
            message
        }
    }

    override fun onCleared() {
        super.onCleared()
    }

}
