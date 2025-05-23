package com.example.myapplication.ui.grupo

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapter.Membro
import com.example.myapplication.model.alunos;

class AlunosFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_alunos, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.tv_members)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = Membro(alunos) { member ->
            val intent = Intent(context, AlunosDetalheActivity::class.java)
            intent.putExtra("name", member.nome)
            intent.putExtra("ra", member.ra)
            startActivity(intent)
        }
        recyclerView.addItemDecoration(
            DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        )
        return view
    }
}