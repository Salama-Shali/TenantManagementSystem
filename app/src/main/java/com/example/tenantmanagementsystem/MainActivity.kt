package com.example.tenantmanagementsystem

import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var tenantName = findViewById<EditText>(R.id.EditTenantName)
        var tenantPhoneNumber = findViewById<EditText>(R.id.EditPhone)
        var rentPaid = findViewById<EditText>(R.id.EditRent)
        var buttonDisplay= findViewById<Button>(R.id.ButtonSaveDetails)
        var displayTextView = findViewById<TextView>(R.id.TextviewDisplay)


        buttonDisplay.setOnClickListener {

        }

        var name = tenantName.text.toString()
        var phone = tenantPhoneNumber.text.toString()
        var rent = rentPaid.text.toString()

        displayTextView.text = "The tenant added is: \nTenant Name: $name \nTenant Phone: $phone \nTenant Rent: $rent"

    }
}