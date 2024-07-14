package jjfactory.product.domain.user

class UserCommand {
    data class Create(
        var lastName: String,
        var firstName: String,
        var phone: String,
        val username: String,
        val gender: User.Gender,
        var password: String,
    ){
        fun toEntity(encPassword: String): User{
            return User(
                lastName = lastName,
                firstName = firstName,
                username = username,
                password = encPassword,
                gender = gender,
                phone = phone
            )
        }
    }

}