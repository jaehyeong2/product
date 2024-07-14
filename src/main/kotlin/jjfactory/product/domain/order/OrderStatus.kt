package jjfactory.product.domain.order

enum class OrderStatus {
    NEW,
    PAYMENT_APPROVED,
    PAYMENT_FAILED,
    SHIPPING_IN_PROGRESS,
    SHIPPING_COMPLETED,
    SHIPPING_FAILED,
    COMPLETED,
    CANCELED
}