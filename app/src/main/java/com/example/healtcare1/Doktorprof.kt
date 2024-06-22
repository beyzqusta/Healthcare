package com.example.healtcare1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Doktorprof : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_doktorprof)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val b = findViewById<Button>(R.id.doctorg)
        b.setOnClickListener {
            val c = Intent(this,dprofilgoruntule::class.java)
            startActivity(c)


        }

        val d = findViewById<Button>(R.id.docorgg)
        d.setOnClickListener {
            val e= Intent(this,dprofilgoruntule2::class.java)
            startActivity(e)
        }

        val f=findViewById<Button>(R.id.doctorggg)
        f.setOnClickListener {
            val g= Intent(this,dprofilgoruntule3::class.java)
            startActivity(g)
        }

        val h = findViewById<Button>(R.id.doktorg)
        h.setOnClickListener {
            val i =Intent(this,dprofilgoruntule4::class.java)
            startActivity(i)
        }

        val m=findViewById<Button>(R.id.doktorgg)
        m.setOnClickListener {
            val n=Intent(this,dprofilgoruntule5::class.java)
            startActivity(n)
        }


        val o = findViewById<Button>(R.id.doktorggg)
        o.setOnClickListener {
            val p =Intent(this,dprofilgoruntule6::class.java)
            startActivity(p)
        }



    }
}