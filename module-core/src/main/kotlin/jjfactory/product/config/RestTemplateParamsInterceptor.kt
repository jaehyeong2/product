package jjfactory.product.config

import org.slf4j.LoggerFactory
import org.springframework.http.HttpRequest
import org.springframework.http.client.ClientHttpRequestExecution
import org.springframework.http.client.ClientHttpRequestInterceptor
import org.springframework.http.client.ClientHttpResponse
import org.springframework.stereotype.Component
import org.springframework.util.StreamUtils
import java.net.URI
import java.nio.charset.StandardCharsets

@Component
class RestTemplateParamsInterceptor : ClientHttpRequestInterceptor {

    private val logger = LoggerFactory.getLogger(javaClass)

    override fun intercept(
        request: HttpRequest,
        body: ByteArray,
        execution: ClientHttpRequestExecution
    ): ClientHttpResponse {
        val uri = request.uri
        traceRequest(request, body)
        val response = execution.execute(request, body)

        traceResponse(response, uri)
        return response
    }

    private fun traceRequest(request: HttpRequest, body: ByteArray) {
        val reqLog = StringBuilder()
        reqLog
            .append("[REQUEST] ")
            .append("Uri : ")
            .append(request.uri)
            .append(", Method : ")
            .append(request.method)
            .append(", Request Body : ")
            .append(String(body, StandardCharsets.UTF_8))
        logger.info(reqLog.toString())
    }

    private fun traceResponse(response: ClientHttpResponse, uri: URI) {
        val resLog = java.lang.StringBuilder()
        val needResponseBody = response.statusCode.value() / 100 >= 4 // if response code is >= 400
        resLog
            .append("[RESPONSE] ")
            .append("Uri : ")
            .append(uri)
            .append(", Status code : ")
            .append(response.statusCode)
            .append(", Response Body : ")
            .append(
                if (needResponseBody) StreamUtils.copyToString(
                    response.body,
                    StandardCharsets.UTF_8
                ) else "[no error... trimmed]"
            )
        logger.info(resLog.toString())
    }

}