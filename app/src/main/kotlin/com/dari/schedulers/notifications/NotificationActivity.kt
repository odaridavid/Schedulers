package com.dari.schedulers.notifications

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import com.dari.schedulers.R
import com.google.android.material.button.MaterialButton

class NotificationActivity : AppCompatActivity() {

    companion object {
        const val NOTIFICATION_ID = 1
        val notificationsProvider = NotificationsProvider()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        findViewById<MaterialButton>(R.id.send_notification_button).apply {
            setOnClickListener { initNotifications()}
        }


    }


    private fun initNotifications() {

        notificationsProvider.buildNotification(
            this,
            NOTIFICATION_CHANNELS[ChannelID.PRIMARY]!!,
            NOTIFICATION_ID,
            "Notification Check",
            5,
            "Check Notifications Working As Expected"
        ) { channelId ->
            NotificationCompat.Builder(this, channelId)
                .setContentTitle("Display Notifications")
                .setContentText("Notification Content Displayed")
                .setSmallIcon(R.drawable.ic_notifications)
        }
    }
}
