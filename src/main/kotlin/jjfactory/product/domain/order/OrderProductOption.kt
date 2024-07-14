package jjfactory.product.domain.order

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
class OrderProductOption(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    val order: Order,
    val optionId: Long,

    val qty: Int,
    val amount: Int,

    @CreationTimestamp
    val createdAt: LocalDateTime?= null,
    @UpdateTimestamp
    var updatedAt: LocalDateTime? = null
) {

    fun getTotalAmount(): Int {
        return qty * amount
    }
}