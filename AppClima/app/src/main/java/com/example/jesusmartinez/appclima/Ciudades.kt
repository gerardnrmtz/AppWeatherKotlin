package com.example.jesusmartinez.appclima

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class Ciudades : AppCompatActivity() {

    val TAG="com.example.jesusmartinez.appclima.ciudades.Ciudad"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciudades)

        val bt_mexico=findViewById<Button>(R.id.btMexico)

        val bt_berlin=findViewById<Button>(R.id.btBerlin)

        bt_mexico.setOnClickListener {

            val  intent=Intent(this,MainActivity::class.java)

            intent.putExtra(TAG,"3981254")

            startActivity(intent)
        }
        bt_berlin.setOnClickListener {
            val intent=Intent(this,MainActivity::class.java)

            intent.putExtra(TAG,"2950159")

            startActivity(intent)


        }
    }
}
