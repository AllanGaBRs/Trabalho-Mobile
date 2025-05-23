package com.example.myapplication.adapter;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.Alunos

class Membro(private val listMember: List<Alunos>, private val onClick: (Alunos) -> Unit) :
    RecyclerView.Adapter<Membro.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.tv_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.aluno_cartao, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = listMember.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val member = listMember[position]
        holder.name.text = member.nome
        holder.itemView.setOnClickListener { onClick(member)}
    }



}