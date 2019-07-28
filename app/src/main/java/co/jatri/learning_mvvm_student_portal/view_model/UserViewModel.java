package co.jatri.learning_mvvm_student_portal.view_model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import co.jatri.learning_mvvm_student_portal.model.UserModel;
import co.jatri.learning_mvvm_student_portal.repo.UserRepo;

public class UserViewModel extends ViewModel {

    private final UserRepo userRepo;

    public UserViewModel() {
        userRepo = new UserRepo();
    }

    public LiveData<UserModel> locateUserNetworkProvider(String phone, String name) {
        return userRepo.networkProviderLocator(phone, name);
    }

    public LiveData<String> vaildateMobileNumber(String mobile, String name) {
        return Transformations.map(userRepo.networkProviderLocator(mobile, name), user -> {
            String message;
            if (user.getPhone().length() == 11) {
                message = "valid";
            } else {
                message = "invalid";
            }
            return message;
        });
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

}
