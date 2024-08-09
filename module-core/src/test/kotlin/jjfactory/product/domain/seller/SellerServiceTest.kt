package jjfactory.product.domain.seller

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
class SellerServiceTest(
    @Autowired private val sellerService: SellerService
) {

    @Transactional
    @Test
    fun joinTest() {
        val manager = SellerManagerCommand.Create(
            email = "wogud222@naber.com",
            password = "!234",
            lastName = "lee",
            firstName = "jj",
            phone = "01012341234"
        )

        val seller = SellerCommand.Create(
            name = "test-seller",
            bizNum = "1112223334",
            manager = manager
        )

        val sellerId = sellerService.sellerPost(seller)

        assertThat(sellerId).isNotNull()
    }

}