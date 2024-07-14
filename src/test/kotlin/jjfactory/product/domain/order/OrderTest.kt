package jjfactory.product.domain.order

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class OrderTest {
    @Test
    fun orderCancel() {
        val order = Order(
            userId = 2L,
            amount = 20000,
        )

        order.cancel()

        assertThat(order.status).isEqualTo(OrderStatus.CANCELED)
    }

    @Test
    fun orderCancelFailed() {
        val order = Order(
            userId = 2L,
            amount = 20000,
            status = OrderStatus.COMPLETED
        )



        assertThatThrownBy {
            order.cancel()
        }.isInstanceOf(IllegalStateException::class.java)
    }


}