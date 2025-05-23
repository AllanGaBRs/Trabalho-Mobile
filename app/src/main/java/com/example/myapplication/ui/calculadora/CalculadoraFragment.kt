package com.example.myapplication.ui.calculadora

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.example.myapplication.R

class CalculadoraFragment : Fragment() {

    private lateinit var note1: EditText
    private lateinit var note2: EditText
    private lateinit var note3: EditText
    private lateinit var note4: EditText
    private lateinit var btnCalculate: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_calculadora, container, false)

        note1 = view.findViewById(R.id.et_note1)
        note2 = view.findViewById(R.id.et_note2)
        note3 = view.findViewById(R.id.et_note3)
        note4 = view.findViewById(R.id.et_note4)
        btnCalculate = view.findViewById(R.id.btn_calculate)

        btnCalculate.setOnClickListener {
            val n1 = note1.text.toString().replace(",", ".").toFloatOrNull()
            val n2 = note2.text.toString().replace(",", ".").toFloatOrNull()
            val n3 = note3.text.toString().replace(",", ".").toFloatOrNull()
            val n4 = note4.text.toString().replace(",", ".").toFloatOrNull()

            if (n1 != null && n2 != null && n3 != null && n4 != null) {
                val avg = (n1 + n2 + n3 + n4) / 4
                val result = when {
                    avg < 4 -> "Reprovado"
                    avg < 6 -> "Recuperação"
                    else -> "Aprovado"
                }

                Snackbar.make(
                    view,
                    "Média: %.1f - %s".format(avg, result),
                    Snackbar.LENGTH_INDEFINITE
                )
                    .setAction("Resetar") {
                        note1.text.clear()
                        note2.text.clear()
                        note3.text.clear()
                        note4.text.clear()
                    }
                    .setActionTextColor(Color.GREEN)
                    .show()

            } else {
                Snackbar.make(view, "Digite notas válidas", Snackbar.LENGTH_LONG).show()
            }
        }

        return view
    }
}
