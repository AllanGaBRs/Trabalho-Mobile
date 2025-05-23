package com.example.myapplication.adapter;

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.ui.grupo.AlunosFragment
import com.example.myapplication.ui.calculadora.CalculadoraFragment

class PageView(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) AlunosFragment() else CalculadoraFragment()
    }
}