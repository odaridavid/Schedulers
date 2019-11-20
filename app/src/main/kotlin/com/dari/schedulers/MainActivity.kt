package com.dari.schedulers

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dari.schedulers.notifications.NotificationActivity
import com.google.android.material.card.MaterialCardView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<MaterialCardView>(R.id.notifications_card_view).apply {
            setOnClickListener {
                val intent = Intent(this@MainActivity, NotificationActivity::class.java)
                startActivity(intent)
            }
        }

    }
}
