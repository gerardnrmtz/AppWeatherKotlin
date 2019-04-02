package com.example.jesusmartinez.appclima

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    var tv_ciudad:TextView?=null
    var tv_grados:TextView?=null
    var tv_status:TextView?=null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_ciudad=findViewById(R.id.ciudad)
        tv_grados=findViewById(R.id.grados)
        tv_status=findViewById(R.id.estado)

        val ciudad=intent.getStringExtra("com.example.jesusmartinez.appclima.ciudades.Ciudad")

        if(Network.hayRed(this)) {
            SolicitudHttpVolley("https://api.openweathermap.org/data/2.5/weather?id="+ciudad+"&appid=898a8db3af3a78272cfe37a07f3312cb&units=metric&lang=es")
        }else{
            Toast.makeText(this,"No hay red",Toast.LENGTH_SHORT)
        }
    }
    private fun SolicitudHttpVolley(url: String){
        val queue= Volley.newRequestQueue(this)
        val solicitud= StringRequest(Request.Method.GET,url, Response.Listener<String>{
                response ->
            try {


                Log.d("SolicitudHttpVolley",response)
                val gson=Gson()
                val ciudad=gson.fromJson(response,Ciudad::class.java)
                Log.d("Gson",ciudad.name)
                tv_ciudad?.text=ciudad.name
                tv_grados?.text=ciudad.main?.temp.toString()+"º"
                tv_status?.text=ciudad.weather?.get(0)?.description.toString()

            }
            catch (e: Exception)
            {

            }

        }, Response.ErrorListener {


        })
        queue.add(solicitud)
    }
}
