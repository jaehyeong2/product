package jjfactory.product.domain.order

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OrderService(
    private val orderRepository: OrderRepository
) {
    @Transactional
    fun orderPost(userId: Long, command: OrderCommand.Create): Long {
        val initOrder = command.toEntity(userId)

        return orderRepository.save(initOrder).id!!
    }

    @Transactional
    fun cancel(code: String){
        orderRepository.findByOrderCode(code)?.cancel()
    }
}