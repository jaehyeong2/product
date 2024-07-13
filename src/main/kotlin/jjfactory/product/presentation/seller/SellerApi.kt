package jjfactory.product.presentation.seller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/sellers")
@RestController
class SellerApi {

    @PostMapping
    fun join(){

    }

    @GetMapping
    fun getDetail(){

    }


    @PutMapping
    fun modifyInfo(){

    }
}