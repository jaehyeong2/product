package jjfactory.product.domain.product

import jjfactory.product.domain.stock.Stock
import jjfactory.product.exception.InvalidStockException
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class ProductOptionTest {

    @Test
    fun increaseOptionStock() {
        val product = Product(
            sellerId = 2L,
            name = "나이키 반팔"
        )

        val productOptionGroup = ProductOptionGroup(
            name = "레드",
            product = product
        )

        val stock = Stock(
            total = 10,
            remain = 10
        )

        val option = ProductOption(
            name = "L",
            optionGroup = productOptionGroup,
            stock = stock
        )

        option.increaseStock(2)

        assertThat(option.stock!!.remain).isEqualTo(12)
        assertThat(option.stock!!.total).isEqualTo(12)

    }

    @Test
    fun decreaseOptionStock() {
        val product = Product(
            sellerId = 2L,
            name = "나이키 반팔"
        )

        val productOptionGroup = ProductOptionGroup(
            name = "레드",
            product = product
        )

        val stock = Stock(
            total = 10,
            remain = 10
        )

        val option = ProductOption(
            name = "L",
            optionGroup = productOptionGroup,
            stock = stock
        )

        option.decreaseStock(2)

        assertThat(option.stock!!.remain).isEqualTo(8)
        assertThat(option.stock!!.total).isEqualTo(8)

    }

    @Test
    fun decreaseOptionStockThrow() {
        val product = Product(
            sellerId = 2L,
            name = "나이키 반팔"
        )

        val productOptionGroup = ProductOptionGroup(
            name = "레드",
            product = product
        )

        val stock = Stock(
            total = 10,
            remain = 10
        )

        val option = ProductOption(
            name = "L",
            optionGroup = productOptionGroup,
            stock = stock
        )

        assertThatThrownBy {
            option.decreaseStock(12)
        }.isInstanceOf(InvalidStockException::class.java)

    }

}