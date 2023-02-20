package com.example.masacorporal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val peso = findViewById<EditText>(R.id.txtpeso)
        val talla = findViewById<EditText>(R.id.txttalla)
        val imc = findViewById<TextView>(R.id.lblimc)
        val estado = findViewById<TextView>(R.id.lblestado)
        val nuevo = findViewById<Button>(R.id.btnnuevo)
        val calcular = findViewById<Button>(R.id.btncalcular)

        calcular.setOnClickListener {
            var p = 0.0
            var t = 0.0
            var indicemc = 0.0
            p=peso.text.toString().toDouble()
            t=talla.text.toString().toDouble()
            indicemc = p/(t*t)
            imc.setText(String.format("%.2f",indicemc))
            if(indicemc<18.5) estado.setText("bajo de peso")
            if(indicemc>=18.5 && indicemc<25) estado.setText("normal")
        }

        nuevo.setOnClickListener {
            peso.setText("")
            talla.setText("")
            imc.setText("0.00")
            estado.setText("")
            peso.requestFocus()
        }
    }
}