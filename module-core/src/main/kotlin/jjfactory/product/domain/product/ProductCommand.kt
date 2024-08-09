package jjfactory.product.domain.product

class ProductCommand {
    data class Create(
        val name: String,
        val optionGroups: List<ProductOptionGroupCommand.Create> = emptyList()
    )

    data class Update(
        val name: String,
        val optionGroups: List<ProductOptionGroupCommand.Update> = emptyList()
    )
}


class ProductOptionGroupCommand{
    data class Create(
        val name: String,
        val options: List<ProductOptionCommand.Create> = emptyList()
    )

    data class Update(
        val name: String,
        val options: List<ProductOptionCommand.Update> = emptyList()
    )
}

class ProductOptionCommand{
    data class Create(
        val name: String,
    )

    data class Update(
        val name: String,
    )
}