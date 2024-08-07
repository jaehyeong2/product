package jjfactory.product.domain.user

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Table(name = "users")
@Entity
class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    var lastName: String,
    var firstName: String,
    var phone: String,

    val username: String,
    var password: String,

    @Enumerated(EnumType.STRING)
    val gender: Gender,

    @Enumerated(EnumType.STRING)
    var grade: UserGrade = UserGrade.NORMAL,

    @CreationTimestamp
    val createdAt: LocalDateTime?= null,

    @UpdateTimestamp
    var updatedAt: LocalDateTime? = null
) {

    enum class Gender{
        MALE, FEMALE
    }

    fun adjustGrade(purchaseCount: Int){
        grade = if (purchaseCount >= 100) {
            UserGrade.VIP
        }else if (purchaseCount >= 50) {
            UserGrade.SPECIAL
        }else {
            UserGrade.NORMAL
        }
    }

}