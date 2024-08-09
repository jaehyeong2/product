package jjfactory.product.domain.payment

interface PaymentService {
    fun post(data: TossPaymentService.SuccessData): String?
    fun cancel()
    fun refund()
}