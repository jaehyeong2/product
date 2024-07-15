package jjfactory.product.domain.payment

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
class Payment(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val userId: Long,
    val orderId: Long,

    val amount: Int,

    @Enumerated(EnumType.STRING)
    val method: PayMethod,

    @Enumerated(EnumType.STRING)
    var status: Status = Status.READY,

    @CreationTimestamp
    val createdAt: LocalDateTime?= null,
    @UpdateTimestamp
    var updatedAt: LocalDateTime? = null
) {
    enum class Status{
        READY, PAID, CANCELED
    }

    fun pay(){
        status = Status.PAID
    }

    fun cancel(){
        status = Status.CANCELED
    }

}