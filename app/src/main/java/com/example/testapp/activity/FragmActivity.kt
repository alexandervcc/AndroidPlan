package com.example.testapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.example.testapp.R

class FragmActivity : AppCompatActivity() {
    private lateinit var navHostFrag:NavHostFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragm)
        val fragManager = supportFragmentManager

        val f1=Fragment01()
        val f2=Fragment02()

        navHostFrag = supportFragmentManager.findFragmentById(R.id.navHostContainer) as NavHostFragment


//        fragManager.beginTransaction().add(R.id.fragmentContainerView,f1).commit()
//        fragManager.beginTransaction().add(R.id.fragmentContainerView2,f2).commit()
        //Componentes de GEstion de Fragments
//       fragManager.beginTransaction().add(R.id.fragmentContainerView,f1).commit()
//
//
//
//        val btn1 = findViewById<Button>(R.id.btnFr01)
//        val btn2 = findViewById<Button>(R.id.btnFr02)
//
//        btn1.setOnClickListener {
//            val fragTransactions = fragManager.beginTransaction()
//            fragTransactions.remove(f1)
//            fragTransactions.replace(R.id.fragmentContainerView,f1)
//            fragTransactions.commit()
//        }
//
//        btn2.setOnClickListener {
//            val fragTransactions = fragManager.beginTransaction()
//            fragTransactions.replace(R.id.fragmentContainerView,f2)
//            fragTransactions.commit()
//        }
    }

    fun navigate(){
        navHostFrag.navController.navigate(R.id.action_fragment01_to_fragment02)
    }
}