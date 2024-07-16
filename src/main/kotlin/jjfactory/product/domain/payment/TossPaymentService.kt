package jjfactory.product.domain.payment

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.client.RestTemplate
import java.util.*

@Service
class TossPaymentService(
    private val restTemplate: RestTemplate
) : PaymentService {

    private val logger = LoggerFactory.getLogger(javaClass)
    val tossPaymentsUrl = "https://api.tosspayments.com/v1/payments/confirm"

    @Value("\${billing.toss-payments}")
    private lateinit var secretKey: String

    @Transactional
    override fun post(data: SuccessData): String? {
        val encodedKey = getEncodedSecretKey()

        val headers = createHeader(encodedKey)
        val body = TossPaymentRequestBody(
            paymentKey = data.paymentKey,
            orderId = data.orderId,
            amount = data.amount
        )

        val httpRequest = HttpEntity(body, headers)

        val response = restTemplate.exchange(
            tossPaymentsUrl,
            HttpMethod.POST,
            httpRequest,
            String::class.java
        )

        val responseBody = response.body
        logger.info(responseBody)

        return responseBody
    }

    private fun getEncodedSecretKey(): String? {
        val encoder = Base64.getEncoder()
        return encoder.encodeToString("$secretKey:".toByteArray())
    }

    data class SuccessData(
        val paymentKey: String,
        val orderId: String,
        val amount: Int,
    )

    data class TossPaymentRequestBody(
        val paymentKey: String,
        val orderId: String,
        val amount: Int
    )


    private fun createHeader(encodedString: String?): HttpHeaders {
        val headers = HttpHeaders()
        headers["Authorization"] = "Basic $encodedString"
        headers.contentType = MediaType.APPLICATION_JSON
        return headers
    }

    override fun cancel() {
        TODO("Not yet implemented")
    }

    override fun refund() {
        TODO("Not yet implemented")
    }
}
