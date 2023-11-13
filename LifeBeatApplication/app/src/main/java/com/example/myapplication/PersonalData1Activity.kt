package com.example.myapplication
import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PersonalData1Activity : AppCompatActivity() {

    private lateinit var titleTextView: TextView
    private lateinit var genderSpinner: Spinner
    private lateinit var dateOfBirthEditText: EditText
    private lateinit var weightEditText: EditText
    private lateinit var heightEditText: EditText
    private lateinit var continueButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_data_1)

        // Initialize views
        titleTextView = findViewById(R.id.titleTextView)
        genderSpinner = findViewById(R.id.genderSpinner)
        dateOfBirthEditText = findViewById(R.id.dateOfBirthEditText)
        weightEditText = findViewById(R.id.weightEditText)
        heightEditText = findViewById(R.id.heightEditText)
        continueButton = findViewById(R.id.continueButton)

        // Set the username in the title
        val username = intent.getStringExtra("username")
        titleTextView.text = "Hello, $username!"

        // Set up the gender spinner
        ArrayAdapter.createFromResource(
            this,
            R.array.gender_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            genderSpinner.adapter = adapter
        }

        // Set click listener for continue button
        continueButton.setOnClickListener {
            val gender = genderSpinner.selectedItem.toString()
            val dateOfBirth = dateOfBirthEditText.text.toString()
            val weight = weightEditText.text.toString()
            val height = heightEditText.text.toString()

            if (dateOfBirth.isEmpty() || weight.isEmpty() || height.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                // TODO: Add code to save the personal data
                Toast.makeText(this, "Personal data saved successfully", Toast.LENGTH_SHORT).show()
            }
            val intent = Intent(this, PersonalData2Activity::class.java)
            intent.putExtra("username", username)
            startActivity(intent)
        }
        dateOfBirthEditText.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
                val selectedDate = "${selectedDay}/${selectedMonth + 1}/${selectedYear}"
                dateOfBirthEditText.setText(selectedDate)
            }, year, month, day).show()
        }
    }
}
