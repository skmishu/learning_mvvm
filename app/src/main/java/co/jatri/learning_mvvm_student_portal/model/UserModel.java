package co.jatri.learning_mvvm_student_portal.model;

public class UserModel {
    private String name, phone, id, networkProvider;

    public UserModel() {
    }

    public UserModel(String name, String phone, String id, String networkProvider) {
        this.name = name;
        this.phone = phone;
        this.id = id;
        this.networkProvider = networkProvider;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNetworkProvider() {
        return networkProvider;
    }

    public void setNetworkProvider(String networkProvider) {
        this.networkProvider = networkProvider;
    }
}
