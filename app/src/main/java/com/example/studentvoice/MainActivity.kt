package com.example.studentvoice

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val studentName = findViewById<EditText>(R.id.studentName)
        val courseName = findViewById<EditText>(R.id.courseName)
        val ratingGroup = findViewById<RadioGroup>(R.id.ratingGroup)
        val recommend = findViewById<Switch>(R.id.recommend)
        val agree = findViewById<CheckBox>(R.id.agree)
        val submit = findViewById<Button>(R.id.submit)

        submit.setOnClickListener {

            if (!agree.isChecked) {
                Toast.makeText(this, "Please agree to submit feedback", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val selectedId = ratingGroup.checkedRadioButtonId
            val rating = if (selectedId != -1) {
                findViewById<RadioButton>(selectedId).text.toString()
            } else {
                "Not selected"
            }

            val intent = Intent(this, SummaryActivity::class.java)
            intent.putExtra("name", studentName.text.toString())
            intent.putExtra("course", courseName.text.toString())
            intent.putExtra("rating", rating)
            intent.putExtra("recommend", if (recommend.isChecked) "Yes" else "No")

            startActivity(intent)
        }
    }
}