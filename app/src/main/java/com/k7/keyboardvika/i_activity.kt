package com.k7.keyboardvika

import android.content.Context

interface i_activity {
    fun onBackPressed()
    fun setISendCharOnClear(iSendcharonclear: i_sendCharOnClear)
    fun getISendCharOnClear():i_sendCharOnClear?

}