package jjfactory.product.domain.stock

import jakarta.persistence.*
import jjfactory.product.exception.InvalidStockException
import org.hibernate.annotations.Comment
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
class Stock(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Comment("총 설정 재고")
    var total: Int,
    @Comment("남은 재고")
    var remain: Int,

    @CreationTimestamp
    val createdAt: LocalDateTime?= null,

    @UpdateTimestamp
    var updatedAt: LocalDateTime? = null
) {

    fun increase(value: Int){
        validateStock(value)

        total += value
        remain += value
    }

    fun decrease(value: Int){
        validateStock(value)
        val nextTotal = total - value
        validateStock(nextTotal)

        total = nextTotal
        remain -= value
    }

    fun syncCurrent(value: Int){
        remain = value
    }

    private fun validateStock(value: Int){
        if (value < 1) throw InvalidStockException()
    }

}