package jjfactory.product.domain.order

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "orders")
class Order(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val userId: Long,
    val amount:Int,

    //fixme
    val orderCode: String = "",

    @Enumerated(EnumType.STRING)
    var status: OrderStatus = OrderStatus.NEW,

    @CreationTimestamp
    val createdAt: LocalDateTime?= null,

    @UpdateTimestamp
    var updatedAt: LocalDateTime? = null
) {

    fun shippingStart(){
        if (status == OrderStatus.PAYMENT_APPROVED)
            status = OrderStatus.SHIPPING_IN_PROGRESS
    }

    fun cancel(){
        if (setOf(OrderStatus.COMPLETED, OrderStatus.SHIPPING_IN_PROGRESS, OrderStatus.SHIPPING_COMPLETED).contains(status))
            throw IllegalStateException()

        status = OrderStatus.CANCELED
    }
}