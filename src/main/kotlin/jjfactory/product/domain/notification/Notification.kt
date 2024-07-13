package jjfactory.product.domain.notification

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
class Notification(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var content: String,

    var isExposed: Boolean = false,

    @OneToMany
    val images: List<NotificationImage> = emptyList(),

    @CreationTimestamp
    val createdAt: LocalDateTime?= null,
    @UpdateTimestamp
    var updatedAt: LocalDateTime? = null
) {
    fun modifyContent(content: String){
        this.content = content
    }

    fun expose(){
        isExposed = true
    }

    fun hide(){
        isExposed = false
    }
}