package jjfactory.product.domain.product

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional


@SpringBootTest
class ProductServiceTest(
    @Autowired private val productService: ProductService
){

    @Transactional
    @Test
    fun postTest(){
        val option = ProductOptionCommand.Create(
            name = "optionA",
        )

        val group = ProductOptionGroupCommand.Create(
            name = "groupA",
            options = listOf(option)
        )

        val command = ProductCommand.Create(
            name = "testProduct",
            optionGroups = listOf(group)
        )

        productService.productPost(2L, command)
    }



}