package jjfactory.product.domain.product

import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductService(
    private val productRepository: ProductRepository
) {

    @Cacheable(key = "#sellerId", cacheNames = ["products"])
    @Transactional(readOnly = true)
    fun findAllBySellerId(sellerId: Long): List<ProductInfo.Detail> {
        //todo paging

        return productRepository.findAllBySellerId(sellerId).map {
            ProductInfo.Detail(
                id = it.id!!,
                sellerId = it.sellerId,
                name = it.name
            )
        }
    }


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