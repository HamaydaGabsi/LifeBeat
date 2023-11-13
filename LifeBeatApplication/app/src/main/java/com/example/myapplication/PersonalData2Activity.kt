package com.example.myapplication
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PersonalData2Activity : AppCompatActivity() {

    private lateinit var titleTextView: TextView
    private lateinit var physicalActivityCheckBox: CheckBox
    private lateinit var smokingCheckBox: CheckBox
    private lateinit var continueButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_data_2)

        // Initialize views
        titleTextView = findViewById(R.id.titleTextView)
        physicalActivityCheckBox = findViewById(R.id.physicalActivityCheckBox)
        smokingCheckBox = findViewById(R.id.smokingCheckBox)
        continueButton = findViewById(R.id.continueButton)

        // Set the username in the title
        val username = intent.getStringExtra("username")
        titleTextView.text = "Hello, $username!"

        // Set click listener for continue button
        continueButton.setOnClickListener {
            val doesPhysicalActivity = physicalActivityCheckBox.isChecked
            val doesSmoke = smokingCheckBox.isChecked

            // TODO: Add code to save the personal data
            Toast.makeText(this, "Personal data saved successfully", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, PersonalData3Activity::class.java)
            intent.putExtra("username", username)
            startActivity(intent)
        }
    }
}
