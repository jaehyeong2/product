package jjfactory.product.domain.seller

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SellerService(
    private val sellerRepository: SellerRepository
) {

    @Transactional
    fun sellerPost(command: SellerCommand.Create): Long {
        val initSeller = command.toEntity()

        //fixme
        val encPassword = command.manager.password

        val manager = command.manager.toEntity(
            encPassword = encPassword,
            seller = initSeller
        )

        initSeller.addManager(manager)


        val seller = sellerRepository.save(initSeller)

        return seller.id!!
    }
}