package com.example.testapp.activity

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.example.testapp.R
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView

class LateralMenuActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawerLayout:DrawerLayout
    private lateinit var toogle:ActionBarDrawerToggle
    private lateinit var toolbar:MaterialToolbar
    private lateinit var navView:NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lateral_menu)

        drawerLayout = findViewById(R.id.dl)
        //toogle = findViewById(R.id.toogle)
        toolbar = findViewById(R.id.topAppBar)
        navView = findViewById(R.id.nav_view)

        navView.setNavigationItemSelectedListener(this)

        setSupportActionBar(toolbar)

        toogle = ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.app_name,R.string.hello_blank_fragment)

        drawerLayout.addDrawerListener(toogle)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toogle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        if(newConfig!=null){
            super.onConfigurationChanged(newConfig)
        }
        toogle.onConfigurationChanged(newConfig)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var content = ""
        when(item.itemId){
            R.id.item01 -> content = "Item 01"
            R.id.item02 -> content = "Item 02"
            R.id.subitem01 -> content = "Subitem 01"
            R.id.subitem02 -> content = "Subitem 02"
            else -> content = "N/A"
        }
        Toast.makeText(this,"Selected: ${content}",Toast.LENGTH_SHORT).show()
        return true
    }

}