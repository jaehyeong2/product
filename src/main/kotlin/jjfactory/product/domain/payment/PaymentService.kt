package jjfactory.product.domain.payment

interface PaymentService {
    fun post(): Long
    fun cancel()
    fun refund()
}