package jjfactory.product.config

import com.github.benmanes.caffeine.cache.Cache
import com.github.benmanes.caffeine.cache.Caffeine
import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cache.caffeine.CaffeineCacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*
import java.util.concurrent.TimeUnit

@EnableCaching
@Configuration
class CacheConfig {

    enum class CacheType(key: String, val expireTime: Long, val maxSize: Long){
        PRODUCT_INFO(key = "products", expireTime = 12 * 3600, maxSize = 5000)
    }


    @Bean
    fun cacheManager(): CacheManager {
        val cacheManager = CaffeineCacheManager()

        CacheType.values().forEach {
            cacheManager.registerCustomCache(
                it.name,
                buildCache(it)
            )

        }
        return cacheManager
    }

    private fun buildCache(it: CacheType): Cache<Any, Any> =
        Caffeine.newBuilder()
            .recordStats()
            .expireAfterWrite(it.expireTime, TimeUnit.SECONDS)
            .maximumSize(it.maxSize)
            .build()
}