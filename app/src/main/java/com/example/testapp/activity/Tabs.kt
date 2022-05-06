package com.example.testapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.testapp.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class Tabs : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabs)

        val tabs = findViewById<TabLayout>(R.id.tabs)
        val pageViewer = findViewById<ViewPager2>(R.id.vp02)
        TabLayoutMediator(tabs,pageViewer){tab, pos->
            when(pos){
                0 -> tab.text = "frag1"
                1 -> tab.text = "frag2"
                2 -> tab.text = "frag3"

                4 -> tab.text = "frag4"
            }
        }.attach()

        tabs.addOnTabSelectedListener(object:TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                TODO("Not yet implemented")
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                TODO("Not yet implemented")
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                TODO("Not yet implemented")
            }
        })
    }
}