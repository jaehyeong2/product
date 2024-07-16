package jjfactory.product.config

import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpRequest
import org.springframework.http.client.ClientHttpRequestExecution
import org.springframework.http.client.ClientHttpRequestInterceptor
import org.springframework.http.client.ClientHttpResponse
import org.springframework.retry.RetryContext
import org.springframework.retry.policy.SimpleRetryPolicy
import org.springframework.retry.support.RetryTemplate
import org.springframework.web.client.RestTemplate
import java.io.IOException
import java.time.Duration


@Configuration
class RestTemplateConfig(
    private val restTemplateParamsInterceptor: RestTemplateParamsInterceptor
) {
    @Bean
    fun restTemplate(): RestTemplate {
        val restTemplateBuilder = RestTemplateBuilder()

        return restTemplateBuilder
            .setConnectTimeout(Duration.ofSeconds(5))
            .setReadTimeout(Duration.ofSeconds(5))
//            .setBufferRequestBody(true)
            .additionalInterceptors(restTemplateParamsInterceptor, clientHttpRequestInterceptor())
            .build()
    }

    fun clientHttpRequestInterceptor(): ClientHttpRequestInterceptor {
        return ClientHttpRequestInterceptor { request: HttpRequest?, body: ByteArray?, execution: ClientHttpRequestExecution ->
            val retryTemplate = RetryTemplate()
            retryTemplate.setRetryPolicy(SimpleRetryPolicy(2))
//            retryTemplate.setBackOffPolicy()

            try {
                return@ClientHttpRequestInterceptor retryTemplate.execute<ClientHttpResponse, IOException> { context: RetryContext? ->
                    execution.execute(
                        request!!, body!!
                    )
                }
            } catch (ex: IOException) {
                throw RuntimeException()
            }
        }
    }
}