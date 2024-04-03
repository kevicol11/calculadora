package com.kevin.calculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var txtCaja: EditText
    private var operador: String = ""
    private var operando1: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtCaja = findViewById(R.id.txtcaja)
    }

    fun onClickButton(view: View) {
        val button = view as Button
        val value = button.text.toString()

        when {
            value == "C" -> {
                txtCaja.text.clear()
                operador = ""
                operando1 = 0.0
            }

            value == "=" -> {
                val operando2 = txtCaja.text.toString().toDouble()
                val resultado = when (operador) {
                    "+" -> operando1 + operando2
                    "-" -> operando1 - operando2
                    "*" -> operando1 * operando2
                    "/" -> operando1 / operando2
                    else -> 0.0
                }
                txtCaja.setText(resultado.toString())
                operador = ""
                operando1 = 0.0
            }

            value in listOf("+", "-", "*", "/") -> {
                operador = value
                operando1 = txtCaja.text.toString().toDouble()
                txtCaja.text.clear()
            }

            else -> {
                txtCaja.append(value)
            }
        }
    }
}
