package com.k7.keyboardvika.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.k7.keyboardvika.MainActivity
import com.k7.keyboardvika.R
import com.k7.keyboardvika.i_activity
import com.k7.keyboardvika.i_sendCharOnClear


// TODO: Rename parameter arguments, choose names that match

class keyboardDetallFragment : Fragment() {
    private var inText: String? = null
    var listener:i_activity?=null
    var listenerText: i_sendCharOnClear?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            inText = it.getString("textChars")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val b_back = view.findViewById<Button>(R.id.b_backDetal)
        val b_1Detal =  view.findViewById<Button>(R.id.b_1Detal)
        val b_2Detal =  view.findViewById<Button>(R.id.b_2Detal)
        val b_3Detal =  view.findViewById<Button>(R.id.b_3Detal)
        val b_4Detal =  view.findViewById<Button>(R.id.b_4Detal)
        listenerText=listener?.getISendCharOnClear()
        b_back.setOnClickListener {
            listener?.onBackPressed()
        }
        if(inText!=null) {
            b_1Detal.text = inText!![0].toString()
            b_2Detal.text = inText!![1].toString()
            b_3Detal.text = inText!![2].toString()
            b_4Detal.text = inText!![3].toString()

            b_1Detal.setOnClickListener {
                listenerText?.addChar(inText!![0].toString())
                listener?.onBackPressed()
            }
            b_2Detal.setOnClickListener {
                listenerText?.addChar(inText!![1].toString())
                listener?.onBackPressed()
            }
            b_3Detal.setOnClickListener {
                listenerText?.addChar(inText!![2].toString())
                listener?.onBackPressed()
            }
            b_4Detal.setOnClickListener {
                listenerText?.addChar(inText!![3].toString())
                listener?.onBackPressed()
            }
        }
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
        listenerText=null
    }
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_keyboard_detall, container, false)
    }


}