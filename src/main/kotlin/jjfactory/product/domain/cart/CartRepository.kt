package jjfactory.product.domain.cart

import org.springframework.data.jpa.repository.JpaRepository

interface CartRepository : JpaRepository<Cart, Long> {
    fun findAllByUserIdOrderByCreatedAtDesc(userId: Long): List<Cart>
}