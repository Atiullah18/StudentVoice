package com.example.studentvoice

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat

class SummaryActivity : AppCompatActivity() {

    private val TAG = "StudentVoice"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        Log.d(TAG, "onCreate called")

        val summary = findViewById<TextView>(R.id.summary)

        val name = intent.getStringExtra("name")
        val course = intent.getStringExtra("course")
        val rating = intent.getStringExtra("rating")
        val recommend = intent.getStringExtra("recommend")

        summary.text = """
            Student Name:  $name
            
            Course Name:  $course
            
            Course Rating:  $rating
            
            Recommend Course:  $recommend
            
            Feedback Submitted:  Yes
        """.trimIndent()

        Toast.makeText(
            this,
            "Feedback submitted successfully",
            Toast.LENGTH_LONG
        ).show()

        showNotification()
    }

    private fun showNotification() {

        val channelId = "feedback_channel"

        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "Feedback Notifications",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            manager.createNotificationChannel(channel)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
            ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                101
            )
            return
        }

        val notification = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle("Student Voice")
            .setContentText("Feedback submitted successfully")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()

        manager.notify(1, notification)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy called")
    }
}