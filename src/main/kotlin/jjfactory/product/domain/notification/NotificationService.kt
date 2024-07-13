package jjfactory.product.domain.notification

import jjfactory.product.exception.ResourceNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.multipart.MultipartFile

@Service
class NotificationService(
    private val notificationRepository: NotificationRepository
) {

    @Transactional
    fun notificationPost(content: String): Long {
        val initNotification = Notification(
            content = content
        )

        val notification = notificationRepository.save(initNotification)
        return notification.id!!
    }

    @Transactional
    fun modifyNotification(id: Long, content: String): Long {
        val notification = notificationRepository.findByIdOrNull(id) ?: throw ResourceNotFoundException()
        notification.modifyContent(content)

        return notification.id!!
    }
}