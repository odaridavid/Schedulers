package com.dari.schedulers.notifications

import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import com.dari.schedulers.MainActivity
import com.dari.schedulers.R
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.activity_notification.*

class NotificationActivity : AppCompatActivity() {

    companion object {
        const val NOTIFICATION_ID = 1
        val notificationsProvider = NotificationsProvider()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)
        send_notification_button.setOnClickListener {
            initNotifications()
        }
    }


    private fun initNotifications() {

        //set intents
        val intent = Intent(this, MainActivity::class.java).apply{
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

        notificationsProvider.buildNotification(this, NOTIFICATION_CHANNELS[ChannelID.TEST]!!, NOTIFICATION_ID, "Notification Check", 5, "Check Notifications Working As Expected") {
            channelId -> NotificationCompat.Builder(this, channelId)
                .setContentTitle("Display Notifications")
                .setContentText("Notification Content Displayed")
                .setContentIntent(pendingIntent) //add your intent
                .setSmallIcon(R.drawable.ic_notifications)
                .setAutoCancel(true) //add this for the notification to clear itself on-tap
        }
    }
}
