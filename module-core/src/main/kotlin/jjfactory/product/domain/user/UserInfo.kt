package jjfactory.product.domain.user

import java.time.LocalDateTime

class UserInfo {

    data class Detail(
        val id: Long? = null,
        val lastName: String,
        val firstName: String,
        val phone: String,
        val username: String,
        val gender: User.Gender,
        val createdAt: LocalDateTime,
    )
}