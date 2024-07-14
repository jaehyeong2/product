package jjfactory.product.domain.order

class OrderCommand {
    data class Create(
        val options: List<OptionContainer>
    ){
        fun toEntity(userId: Long): Order{
            return Order(
                userId = userId,
            )
        }
    }

    data class OptionContainer(
        val id: Long,
        val qty: Int,
        val amount: Int
    )
}