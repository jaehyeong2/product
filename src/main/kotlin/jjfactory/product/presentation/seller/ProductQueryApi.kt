package jjfactory.product.presentation.seller

import jjfactory.product.domain.product.ProductCommand
import jjfactory.product.domain.product.ProductService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductQueryApi(
    private val productService: ProductService
) {

    @PostMapping
    fun productPost(@RequestBody request: ProductCommand.Create) {
        val loginSellerId = 2L

        productService.productPost(
            sellerId = loginSellerId,
            command = request
        )
    }

}