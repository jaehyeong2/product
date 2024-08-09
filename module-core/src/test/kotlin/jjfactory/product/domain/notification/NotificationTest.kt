package jjfactory.product.domain.notification

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class NotificationTest {

    @Test
    fun hide() {
        val notification = Notification(
            content = "testNoti",
            isExposed = true
        )

        notification.hide()

        assertThat(notification.isExposed).isFalse
    }

    @Test
    fun expose() {
        val notification = Notification(
            content = "testNoti",
        )

        assertThat(notification.isExposed).isFalse

        notification.expose()
        assertThat(notification.isExposed).isTrue
    }

    @Test
    fun modifyContent() {
        val notification = Notification(
            content = "testNoti",
        )

        notification.modifyContent("modified")
        assertThat(notification.content).isEqualTo("modified")
    }


}