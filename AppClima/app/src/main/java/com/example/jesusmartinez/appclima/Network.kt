package com.example.jesusmartinez.appclima

import android.content.Context
import android.net.ConnectivityManager
import android.support.v7.app.AppCompatActivity

class Network {


    companion object {
        fun hayRed(activity: AppCompatActivity):Boolean{

            val connectivityManager=activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val network_info=connectivityManager.activeNetworkInfo

            return  network_info !=null&&network_info.isConnected
        }
    }
}