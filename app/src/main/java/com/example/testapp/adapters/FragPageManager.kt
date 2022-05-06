package com.example.testapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.testapp.fragments.Fragment01
import com.example.testapp.fragments.Fragment02
import com.example.testapp.fragments.Fragment03
import com.example.testapp.fragments.Fragment4

class FragPageManager(fragment:FragmentActivity):FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> Fragment01()
            1 -> Fragment02()
            2 -> Fragment03()
            3 -> Fragment4()
            else -> Fragment4()
        }
    }
}