package jjfactory.product.domain.order

import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository: JpaRepository<Order, Long> {
    fun findByOrderCode(code: String): Order?
}