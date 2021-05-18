package com.k7.keyboardvika.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.makeText
import com.k7.keyboardvika.R
import com.k7.keyboardvika.i_activity
import com.k7.keyboardvika.i_sendCharOnClear


class textFragment : Fragment(),i_sendCharOnClear {
    // TODO: Rename and change types of parameters
    var textViewMain:TextView?=null
    var listener:i_activity?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_text, container, false)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        if (savedInstanceState!=null)
        textViewMain?.text=savedInstanceState?.getString("text")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("text", getAllText());
    }

    fun init(view:View){
        textViewMain=view.findViewById(R.id.tv_textMain)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)
        listener?.setISendCharOnClear(this)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is i_activity){
            listener=context
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        listener=null
    }

    override fun addChar(text: String) {
        if (textViewMain?.text!="Введите текст"){
        textViewMain?.text=textViewMain?.text.toString()+text
        }else{
            textViewMain?.text=text
        }
    }

    override fun delAll() {
        textViewMain?.text="Введите текст"
    }

    override fun delLastChar() {
        var text:String=textViewMain?.text.toString()
        if (text.length>0) {
            val textFinal: String = text.substring(0,text.length-1)
            textViewMain?.text=textFinal
        }
    }

    override fun getAllText(): String {
        return textViewMain?.text.toString()
    }
}