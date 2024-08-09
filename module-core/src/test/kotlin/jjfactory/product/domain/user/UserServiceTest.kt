package jjfactory.product.domain.user

import jjfactory.product.exception.UserNameDuplicateException
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
class UserServiceTest(
    @Autowired private val userService: UserService,
    @Autowired private val userRepository: UserRepository
){

    @Transactional
    @Test
    fun usernameDuplicateCheck(){
        val user = User(
            lastName = "lee",
            firstName = "jj",
            phone = "01012341343",
            username = "test",
            password = "1234",
            gender = User.Gender.MALE
        )

        userRepository.save(user)

        Assertions.assertThatThrownBy{
            val command = UserCommand.Create(
                lastName = "lee",
                firstName = "jj",
                phone = "01012341343",
                username = "test",
                password = "1234",
                gender = User.Gender.MALE
            )

            userService.userPost(command)
        }.isInstanceOf(UserNameDuplicateException::class.java)

    }

}