package jjfactory.product.domain.seller

class SellerCommand {
    data class Create(
        val name: String,
        val bizNum: String,
        val manager: SellerManagerCommand.Create
    ){
        fun toEntity(): Seller {
            return Seller(
                bizNum = bizNum,
                name = name
            )
        }
    }
}

class SellerManagerCommand{
    data class Create(
        val email: String,
        val password: String,
        var lastName: String,
        var firstName: String,
        var phone: String,
    ){
        fun toEntity(encPassword: String, seller: Seller): SellerManager{
            return SellerManager(
                email = email,
                password = encPassword,
                lastName = lastName,
                firstName = firstName,
                phone = phone,
                seller = seller
            )
        }
    }
}
