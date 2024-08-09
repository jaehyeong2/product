package jjfactory.product.domain.seller

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
class SellerManager(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val email: String,
    val password: String,

    @ManyToOne(fetch = FetchType.LAZY)
    val seller: Seller,

    var lastName: String,
    var firstName: String,
    var phone: String,

    @CreationTimestamp
    val createdAt: LocalDateTime?= null,
    @UpdateTimestamp
    var updatedAt: LocalDateTime? = null
) {

}