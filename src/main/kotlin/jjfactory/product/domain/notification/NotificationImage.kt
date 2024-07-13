package jjfactory.product.domain.notification

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
class NotificationImage(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    val notification: Notification,

    val name: String,
    val url: String,

    @CreationTimestamp
    val createdAt: LocalDateTime?= null,
    @UpdateTimestamp
    var updatedAt: LocalDateTime? = null
) {
}