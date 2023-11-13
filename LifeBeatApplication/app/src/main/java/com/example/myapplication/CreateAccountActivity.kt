package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity



class CreateAccountActivity : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var verifyPasswordEditText: EditText
    private lateinit var submitButton: Button
    private lateinit var alreadyHaveAccountButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        // Initialize views
        usernameEditText = findViewById(R.id.usernameEditText)
        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        verifyPasswordEditText = findViewById(R.id.verifyPasswordEditText)
        submitButton = findViewById(R.id.submitButton)
        alreadyHaveAccountButton = findViewById(R.id.alreadyHaveAccountButton)

        // Set click listener for submit button
        submitButton.setOnClickListener {
            val usernameEditText = findViewById<EditText>(R.id.usernameEditText)
            val username = usernameEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val verifyPassword = verifyPasswordEditText.text.toString()

            if (username.isEmpty() || email.isEmpty() || password.isEmpty() || verifyPassword.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else if (password != verifyPassword) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            } else {
                // TODO: Add code to create the account
                Toast.makeText(this, "Account created successfully", Toast.LENGTH_SHORT).show()
            }
            val intent = Intent(this, PersonalData1Activity::class.java)
            intent.putExtra("username", username)
            startActivity(intent)
        }


        alreadyHaveAccountButton.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }

    }
}
