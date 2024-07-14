package jjfactory.product.presentation.seller.dto

class ProductDto {
    data class Create(
        val name: String,
        val optionGroups: List<ProductOptionGroupDto.Create> = emptyList()
    )
}


class ProductOptionGroupDto{
    data class Create(
        val name: String,
        val options: List<ProductOptionDto.Create> = emptyList()
    )
}

class ProductOptionDto{
    data class Create(
        val name: String,
    )
}