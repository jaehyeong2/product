package jjfactory.product.presentation.seller

import jjfactory.product.domain.product.ProductCommand
import jjfactory.product.domain.product.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import kotlin.math.log

@RestController
@RequestMapping("/seller/product")
class ProductQueryApi(
    private val productService: ProductService
) {



    @GetMapping
    fun getProductList(@RequestParam sellerId: Long){
        //todo 인증기반
        val loginSellerId = 2L

        val result = productService.findAllBySellerId(sellerId = sellerId)

        result.forEach {
            println(it)
        }
    }

}