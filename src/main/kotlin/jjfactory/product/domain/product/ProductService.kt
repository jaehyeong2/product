package jjfactory.product.domain.product

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductService(
    private val productRepository: ProductRepository
) {
    @Transactional
    fun productPost(sellerId: Long, command: ProductCommand.Create): Long {
        val initProduct = Product(
            sellerId = sellerId,
            name = command.name
        )

        command.optionGroups.forEach {
            val optionGroup = ProductOptionGroup(
                product = initProduct,
                name = it.name
            )

            initProduct.addOptionGroup(optionGroup)

            it.options.forEach { option ->
                val option = ProductOption(
                    name = option.name,
                    optionGroup = optionGroup
                )

                optionGroup.addOption(option)
            }
        }

        return productRepository.save(initProduct).id!!
    }
}