package com.example.myapplication
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PersonalData3Activity : AppCompatActivity() {

    private lateinit var titleTextView: TextView
    private lateinit var illnessLabel: TextView
    private lateinit var hemochromatosisCheckBox: CheckBox
    private lateinit var cysticFibrosisCheckBox: CheckBox
    private lateinit var huntingtonsDiseaseCheckBox: CheckBox
    private lateinit var pkdCheckBox: CheckBox
    private lateinit var familialHypercholesterolemiaCheckBox: CheckBox
    private lateinit var sickleCellAnemiaCheckBox: CheckBox
    private lateinit var muscularDystrophyCheckBox: CheckBox
    private lateinit var type2DiabetesCheckBox: CheckBox
    private lateinit var continueButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_data_3)

        // Initialize views
        titleTextView = findViewById(R.id.titleTextView)
        illnessLabel = findViewById(R.id.illnessLabel)
        hemochromatosisCheckBox = findViewById(R.id.hemochromatosisCheckBox)
        cysticFibrosisCheckBox = findViewById(R.id.cysticFibrosisCheckBox)
        huntingtonsDiseaseCheckBox = findViewById(R.id.huntingtonsDiseaseCheckBox)
        pkdCheckBox = findViewById(R.id.pkdCheckBox)
        familialHypercholesterolemiaCheckBox = findViewById(R.id.familialHypercholesterolemiaCheckBox)
        sickleCellAnemiaCheckBox = findViewById(R.id.sickleCellAnemiaCheckBox)
        muscularDystrophyCheckBox = findViewById(R.id.muscularDystrophyCheckBox)
        type2DiabetesCheckBox = findViewById(R.id.type2DiabetesCheckBox)
        continueButton = findViewById(R.id.continueButton)

        // Set the username in the title
        val username = intent.getStringExtra("username")
        titleTextView.text = "Hello, $username!"

        // Set click listener for continue button
        continueButton.setOnClickListener {
            // TODO: Add code to save the personal data
            Toast.makeText(this, "Personal data saved successfully", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, AllSetUpActivity::class.java)

            startActivity(intent)
        }
    }
}
