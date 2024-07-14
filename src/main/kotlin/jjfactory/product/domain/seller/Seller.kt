package jjfactory.product.domain.seller

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
class Seller(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val name: String,
    val code: String = "",
    val bizNum: String,

    @OneToMany(mappedBy = "seller", cascade = [CascadeType.ALL])
    val managers: MutableList<SellerManager> = mutableListOf(),

    @CreationTimestamp
    val createdAt: LocalDateTime?= null,

    @UpdateTimestamp
    var updatedAt: LocalDateTime? = null
) {

    fun addManager(manager: SellerManager){
        managers.add(manager)
    }

}