package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.widget.TextView
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val operandOne = findViewById<EditText>(R.id.operandOne)
        val operandTwo = findViewById<EditText>(R.id.operandTwo)
        val operationGroup = findViewById<RadioGroup>(R.id.operationGroup)
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val result = findViewById<TextView>(R.id.result)


        calculateButton.setOnClickListener {
            val op1 = operandOne.text.toString().toDoubleOrNull()
            val op2 = operandTwo.text.toString().toDoubleOrNull()

            if (op1 == null || op2 == null) {
                Toast.makeText(this, "Please enter valid numbers.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            result.text = when (operationGroup.checkedRadioButtonId) {
                R.id.radio_Addition-> (op1 + op2).toString()
                R.id.radio_Subtraction -> (op1 - op2).toString()
                R.id.radio_Multiplication -> (op1 * op2).toString()
                R.id.radio_Division -> {
                    if (op2 == 0.0) {
                        "Cannot divide by zero."
                    } else {
                        (op1 / op2).toString()
                    }
                }
                R.id.radio_Modulus -> {
                    if (op2 == 0.0) {
                        "Cannot take modulus with zero."
                    } else {
                        (op1 % op2).toString()
                    }
                }
                else->{
                    "Please do calculatioin"
                }
            }
        }
    }
}