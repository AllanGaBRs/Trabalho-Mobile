package com.example.myapplication.ui.grupo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import com.example.myapplication.R

class AlunosDetalheActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_alunos)

        val toolbar = findViewById<MaterialToolbar>(R.id.appBar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbar.setNavigationOnClickListener {
            finish()
        }

        val name = intent.getStringExtra("name")
        val ra = intent.getStringExtra("ra")

        findViewById<TextView>(R.id.tv_name_detail).text = "Nome: $name"
        findViewById<TextView>(R.id.tv_ra).text = "R.A: $ra"
    }
}