package com.caua.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var textResp: TextView

    private var numero1 = 0.0
    private var operacao = ""
    private var novoNumero = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textResp = findViewById<TextView>(R.id.textResp)

        val botoes = listOf(
            R.id.button0, R.id.button1, R.id.button2, R.id.button3,
            R.id.button4, R.id.button5, R.id.button6,
            R.id.button7, R.id.button8, R.id.button9
        )

        // Repetição (exigência do trabalho)
        for (id in botoes) {
            val botao = findViewById<Button>(id)
            botao.setOnClickListener {
                digitarNumero(botao.text.toString())
            }
        }

        findViewById<Button>(R.id.buttonAd).setOnClickListener { selecionarOperacao("+") }
        findViewById<Button>(R.id.buttonSub).setOnClickListener { selecionarOperacao("-") }
        findViewById<Button>(R.id.buttonMult).setOnClickListener { selecionarOperacao("*") }
        findViewById<Button>(R.id.buttonDiv).setOnClickListener { selecionarOperacao("/") }

        findViewById<Button>(R.id.buttonResp).setOnClickListener { calcular() }
        findViewById<Button>(R.id.buttonClear).setOnClickListener { limpar() }
    }

    private fun digitarNumero(num: String) {
        if (novoNumero) {
            textResp.text = num
            novoNumero = false
        } else {
            textResp.append(num)
        }
    }

    private fun selecionarOperacao(op: String) {
        numero1 = textResp.text.toString().toDouble()
        operacao = op
        novoNumero = true
    }

    private fun calcular() {
        val numero2 = textResp.text.toString().toDouble()
        var resultado = 0.0

        // if/else (exigência do trabalho)
        if (operacao == "+") {
            resultado = numero1 + numero2
        } else if (operacao == "-") {
            resultado = numero1 - numero2
        } else if (operacao == "*") {
            resultado = numero1 * numero2
        } else if (operacao == "/") {
            if (numero2 == 0.0) {
                textResp.text = "Erro: divisão por zero"
                return
            } else {
                resultado = numero1 / numero2
            }
        }

        textResp.text = resultado.toString()
        novoNumero = true
    }

    private fun limpar() {
        textResp.text = "0"
        numero1 = 0.0
        operacao = ""
        novoNumero = true
    }
}