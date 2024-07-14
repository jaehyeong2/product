package jjfactory.product.presentation.seller

import jjfactory.product.domain.seller.SellerCommand
import jjfactory.product.domain.seller.SellerService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/sellers")
@RestController
class SellerApi(
    private val sellerService: SellerService
) {

    @PostMapping
    fun join(@RequestBody request: SellerCommand.Create){
        sellerService.sellerPost(request)
    }

    @GetMapping
    fun getDetail(){

    }


    @PutMapping
    fun modifyInfo(){

    }
}