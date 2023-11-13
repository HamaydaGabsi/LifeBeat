package com.example.myapplication
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AllSetUpActivity : AppCompatActivity() {

    private lateinit var setupTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_set_up)

        // Initialize views
        setupTextView = findViewById(R.id.setupTextView)


        // Load the loading animation


        // After 3 seconds, update the text and stop the loading animation
        Handler(Looper.getMainLooper()).postDelayed({
            setupTextView.text = "You are ready to go"


        }, 3000)
    }
}
