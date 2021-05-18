package com.k7.keyboardvika

interface i_sendCharOnClear {
    fun addChar(text:String)
    fun delAll()
    fun delLastChar()
    fun getAllText():String
}