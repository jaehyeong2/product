package jjfactory.product.domain.cart

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CartService(
    private val cartRepository: CartRepository
) {

    @Transactional
    fun addProductToCart(userId:Long, productId: Long): Long {
        val initCart = Cart(
            userId = userId,
            productId = productId
        )

        return cartRepository.save(initCart).id!!
    }

    @Transactional(readOnly = true)
    fun getMyCartList(userId: Long){

    }

    @Transactional
    fun deleteFromCart(id: Long){
        cartRepository.deleteById(id)
    }
}