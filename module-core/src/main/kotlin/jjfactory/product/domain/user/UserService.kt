package jjfactory.product.domain.user

import jjfactory.product.exception.ResourceNotFoundException
import jjfactory.product.exception.UserNameDuplicateException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository
) {

    @Transactional
    fun userPost(command: UserCommand.Create): Long {
        if (userRepository.existsByUsername(command.username)) throw UserNameDuplicateException()

        //fixme
        val encPassword = command.password

        val initUser = command.toEntity(encPassword)
        return userRepository.save(initUser).id!!
    }

    @Transactional(readOnly = true)
    fun getUserInfo(id: Long): UserInfo.Detail {
        val user = userRepository.findByIdOrNull(id) ?: throw ResourceNotFoundException()

        return UserInfo.Detail(
            id = user.id!!,
            lastName = user.lastName,
            firstName = user.firstName,
            phone = user.phone,
            gender = user.gender,
            username = user.username,
            createdAt = user.createdAt!!
        )
    }
}