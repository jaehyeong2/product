package jjfactory.product.domain.user

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class UserTest{

    @Test
    fun adjustGrade(){
        val lastOrderCount = 20

        val user = User(
            lastName = "lee",
            firstName = "jj",
            gender = User.Gender.MALE,
            password = "1234",
            phone = "01012341234",
            username = "tester"
        )

        user.adjustGrade(lastOrderCount)
        Assertions.assertThat(user.grade).isEqualTo(UserGrade.NORMAL)

        user.adjustGrade(60)
        Assertions.assertThat(user.grade).isEqualTo(UserGrade.SPECIAL)

        user.adjustGrade(100)
        Assertions.assertThat(user.grade).isEqualTo(UserGrade.VIP)

        user.adjustGrade(0)
        Assertions.assertThat(user.grade).isEqualTo(UserGrade.NORMAL)
    }
}