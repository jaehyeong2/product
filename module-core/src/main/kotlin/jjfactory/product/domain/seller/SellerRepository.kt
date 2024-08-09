package jjfactory.product.domain.seller

import org.springframework.data.jpa.repository.JpaRepository

interface SellerRepository: JpaRepository<Seller, Long> {
}