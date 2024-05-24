package com.example.ejercicioclase

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var btnuno =
            findViewById<Button>(R.id.btnuno)

        var btndos =
            findViewById<Button>(R.id.btndos)

        var btntres =
            findViewById<Button>(R.id.btntres)

        var btncuatro =
            findViewById<Button>(R.id.btncuatro)

        var btncinco =
            findViewById<Button>(R.id.btncinco)


        var btnsiete =
            findViewById<Button>(R.id.btnocho)

        btnuno.setOnClickListener {
            cambioFragment(1)
        }

        btndos.setOnClickListener {
            cambioFragment(2)
        }


        btncuatro.setOnClickListener {
            cambioFragment(4)
        }
        btncinco.setOnClickListener {
            cambioFragment(5)
        }


    }

    //método que gestiona el cambio de framentos
    fun cambioFragment(position: Int) {
        //position:indica el fragmento deseado
        //fragment: indica el fragmento a cambiar
        var fragment: Fragment
        when (position) {
            //segun el valor de position
            //se va a cambiar el fragmento
            1 -> fragment = LinearLayout()
            2 -> fragment = relativeLayout()

            4 -> fragment = ConstraintLayout()
            5 -> fragment = CardView()


            else -> fragment = LinearLayout()
        }
        //supportFragmentManager es el que gestiona el cambio de fragmentos
        val fragmentManager = supportFragmentManager

        //se crea el objeto de la transicin del fragmento
        val fragmentTransition = fragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.FCV, fragment)

        fragmentTransition.commit()
    }

    fun cambiologin(view: View) {
        var intent = Intent(application, login::class.java)
        startActivity(intent)
    }
    fun Cartas(view: View) {
        var intent = Intent(application, CartasNoticias::class.java)
        startActivity(intent)
    }
    fun Info(view: View) {
        var intent = Intent(application, InformaciondelaApp::class.java)
        startActivity(intent)
    }
    fun List(view: View) {
        var intent = Intent(application, listaview::class.java)
        startActivity(intent)
    }

}
