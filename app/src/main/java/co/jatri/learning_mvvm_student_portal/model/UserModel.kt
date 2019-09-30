package co.jatri.learning_mvvm_student_portal.model

class UserModel {
    var name: String? = null
    var phone: String? = null
    var id: String? = null
    var networkProvider: String? = null

    constructor(name: String, phone: String, id: String, networkProvider: String) {
        this.name = name
        this.phone = phone
        this.id = id
        this.networkProvider = networkProvider
    }
}
