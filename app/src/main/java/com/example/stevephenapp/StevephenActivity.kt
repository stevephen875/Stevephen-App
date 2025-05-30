package com.example.stevephenapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class StevephenActivity : AppCompatActivity() {

    private lateinit var etNumber1: EditText
    private lateinit var etNumber2: EditText
    private lateinit var btnAdd: Button
    private lateinit var btnMultiply: Button
    private lateinit var btnDivide: Button
    private lateinit var tvResultLabel: TextView
    private lateinit var tvResultValue: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stevephen)

        etNumber1 = findViewById(R.id.etNumber1)
        etNumber2 = findViewById(R.id.etNumber2)
        btnAdd = findViewById(R.id.btnAdd)
        btnMultiply = findViewById(R.id.btnMultiply)
        btnDivide = findViewById(R.id.btnDivide)
        tvResultLabel = findViewById(R.id.tvResultLabel)
        tvResultValue = findViewById(R.id.tvResultValue)

        btnAdd.setOnClickListener { calculate('+') }
        btnMultiply.setOnClickListener { calculate('*') }
        btnDivide.setOnClickListener { calculate('/') }
    }

    private fun calculate(operator: Char) {
        val num1 = etNumber1.text.toString().toDoubleOrNull()
        val num2 = etNumber2.text.toString().toDoubleOrNull()

        if (num1 == null || num2 == null) {
            tvResultValue.text = "Input tidak valid"
            return
        }

        val result: Any = when (operator) {
            '+' -> num1 + num2
            '*' -> num1 * num2
            '/' -> if (num2 != 0.0) num1 / num2 else "Tidak bisa bagi 0"
            else -> "Operasi tidak dikenali"
        }

        tvResultValue.text = formatHasil(result)
    }

    private fun formatHasil(value: Any): String {
        return if (value is Double && value == value.toInt().toDouble()) {
            value.toInt().toString()
        } else {
            value.toString()
        }
    }
}
