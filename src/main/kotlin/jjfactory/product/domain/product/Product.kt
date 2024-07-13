package jjfactory.product.domain.product

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
class Product(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val sellerId: Long,

    @OneToMany(mappedBy = "product", cascade = [CascadeType.ALL])
    val optionGroups: MutableList<ProductOptionGroup> = mutableListOf(),

    var name: String,

    @CreationTimestamp
    val createdAt: LocalDateTime?= null,

    @UpdateTimestamp
    var updatedAt: LocalDateTime? = null
) {

    fun addOptionGroup(optionGroup: ProductOptionGroup){
        optionGroups.add(optionGroup)
    }

}