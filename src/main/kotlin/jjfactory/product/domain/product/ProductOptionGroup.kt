package jjfactory.product.domain.product

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
class ProductOptionGroup(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    val product: Product,

    @OneToMany(mappedBy = "product_option_group", cascade = [CascadeType.ALL])
    val options: MutableList<ProductOption> = mutableListOf(),
    var name: String,

    @CreationTimestamp
    val createdAt: LocalDateTime?= null,

    @UpdateTimestamp
    var updatedAt: LocalDateTime? = null
) {

    fun addOption(option: ProductOption){
        options.add(option)
    }

}