package jjfactory.product.domain.order

class OrderCommand {
    data class Create(
        val optionId: Long,
        val amount: Int
    ){
        fun toEntity(userId: Long): Order{
            return Order(
                userId = userId,
                amount = amount
            )
        }
    }
}