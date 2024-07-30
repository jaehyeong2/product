package jjfactory.product.domain.product

class ProductInfo {
    data class Detail(
        val id: Long,
        val sellerId: Long,
        val name: String,
    )
}