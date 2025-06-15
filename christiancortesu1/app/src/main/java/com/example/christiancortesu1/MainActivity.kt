package com.example.christiancortesu1

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private val precioPastel = 12000
    private val precioCazuela = 10000
    private val porcentajePropina = 0.1 // 10%

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etPastel = findViewById<EditText>(R.id.etPastelDeChoclo)
        val etCazuela = findViewById<EditText>(R.id.etCazuela)
        val sPropina = findViewById<Switch>(R.id.sPropina)

        val tvSumaComida = findViewById<TextView>(R.id.tvSumaComida)
        val tvSumaPropina = findViewById<TextView>(R.id.tvsumaPropina)
        val tvSumaTotal = findViewById<TextView>(R.id.tvsumaTotal)
        val tvSumaCazuela = findViewById<TextView>(R.id.tvsumaCazuela)
        val tvSumaPastel = findViewById<TextView>(R.id.tvsumaPastel)

        val textWatcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                calcularTotal(
                    etPastel, etCazuela, sPropina,
                    tvSumaComida, tvSumaPropina, tvSumaTotal,
                    tvSumaPastel, tvSumaCazuela
                )
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        }

        etPastel.addTextChangedListener(textWatcher)
        etCazuela.addTextChangedListener(textWatcher)

        sPropina.setOnCheckedChangeListener { _, _ ->
            calcularTotal(
                etPastel, etCazuela, sPropina,
                tvSumaComida, tvSumaPropina, tvSumaTotal,
                tvSumaPastel, tvSumaCazuela
            )
        }

        // Inicializar totales en 0
        calcularTotal(
            etPastel, etCazuela, sPropina,
            tvSumaComida, tvSumaPropina, tvSumaTotal,
            tvSumaPastel, tvSumaCazuela
        )
    }

    private fun calcularTotal(
        etPastel: EditText,
        etCazuela: EditText,
        sPropina: Switch,
        tvSumaComida: TextView,
        tvSumaPropina: TextView,
        tvSumaTotal: TextView,
        tvSumaPastel: TextView,
        tvSumaCazuela: TextView
    ) {
        val cantidadPastel = etPastel.text.toString().toIntOrNull() ?: 0
        val cantidadCazuela = etCazuela.text.toString().toIntOrNull() ?: 0

        val subtotalPastel = cantidadPastel * precioPastel
        val subtotalCazuela = cantidadCazuela * precioCazuela
        val sumaComida = subtotalPastel + subtotalCazuela
        val propina = if (sPropina.isChecked) (sumaComida * porcentajePropina).toInt() else 0
        val total = sumaComida + propina

        val formatoCLP = NumberFormat.getCurrencyInstance(Locale("es", "CL"))
        formatoCLP.maximumFractionDigits = 0


        tvSumaPastel.text = formatoCLP.format(subtotalPastel)
        tvSumaCazuela.text = formatoCLP.format(subtotalCazuela)
        tvSumaComida.text = formatoCLP.format(sumaComida)
        tvSumaPropina.text = formatoCLP.format(propina)
        tvSumaTotal.text = formatoCLP.format(total)
    }
}
