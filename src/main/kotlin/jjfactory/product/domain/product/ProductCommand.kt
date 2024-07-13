package jjfactory.product.domain.product

class ProductCommand {
    data class Create(
        val name: String,
        val optionGroups: List<ProductOptionGroupCommand.Create> = emptyList()
    )
}


class ProductOptionGroupCommand{
    data class Create(
        val name: String,
        val options: List<ProductOptionCommand.Create> = emptyList()
    )
}

class ProductOptionCommand{
    data class Create(
        val name: String,
    )
}