package jjfactory.product.domain.product

import jakarta.persistence.*
import jjfactory.product.domain.stock.Stock
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
class ProductOption(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    val optionGroup: ProductOptionGroup,
    var name: String,

    @OneToOne(fetch = FetchType.LAZY)
    val stock: Stock? = null,

    @CreationTimestamp
    val createdAt: LocalDateTime?= null,

    @UpdateTimestamp
    var updatedAt: LocalDateTime? = null
) {

    fun modifyName(name: String){
        this.name = name
    }

    fun increaseStock(value: Int){
        stock?.increase(value)
    }

    fun decreaseStock(value: Int){
        stock?.decrease(value)
    }

    fun syncStock(value: Int){
        stock?.syncCurrent(value)
    }

}