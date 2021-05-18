package com.k7.keyboardvika


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity(),i_activity {
    var i_text:i_sendCharOnClear?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun setISendCharOnClear(iSendcharonclear: i_sendCharOnClear) {
        i_text=iSendcharonclear
    }

    override fun getISendCharOnClear(): i_sendCharOnClear? {
        return i_text
    }
}