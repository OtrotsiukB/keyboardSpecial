package com.k7.keyboardvika.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.k7.keyboardvika.R
import com.k7.keyboardvika.i_activity
import com.k7.keyboardvika.i_sendCharOnClear



class keybordFragment : Fragment() {

    var listener: i_activity?=null
    var listenerText: i_sendCharOnClear?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_keybord, container, false)
    }

    fun init(view: View){
        val b2 = view.findViewById<Button>(R.id.b_2)
        val b1 = view.findViewById<Button>(R.id.b_1)
        val b3 = view.findViewById<Button>(R.id.b_3)
        val b4 = view.findViewById<Button>(R.id.b_4)
        val b5 = view.findViewById<Button>(R.id.b_5)
        val b6 = view.findViewById<Button>(R.id.b_6)
        val b7 = view.findViewById<Button>(R.id.b_7)
        val b8 = view.findViewById<Button>(R.id.b_8)
        val b9 = view.findViewById<Button>(R.id.b_9)
        val b0 = view.findViewById<Button>(R.id.b_0)
        val b_del = view.findViewById<Button>(R.id.b_del)
        val b_delAll = view.findViewById<Button>(R.id.b_delAll)
        val b_send = view.findViewById<Button>(R.id.b_send)
        b_del.setOnClickListener {
            listenerText?.delLastChar()
        }
        b_delAll.setOnClickListener {
            listenerText?.delAll()
        }
        b0.setOnClickListener {
            listenerText?.addChar(" ")
        }
        b2.setOnClickListener {
            val bundle = bundleOf("textChars" to "АБВГ")
            view.findNavController().navigate(R.id.action_keybordFragment_to_keyboardDetallFragment, bundle)
        }
        b1.setOnClickListener {
            val bundle = bundleOf("textChars" to ".,?!")
            view.findNavController().navigate(R.id.action_keybordFragment_to_keyboardDetallFragment, bundle)
        }
        b3.setOnClickListener {
            val bundle = bundleOf("textChars" to "ДЕЖЗ")
            view.findNavController().navigate(R.id.action_keybordFragment_to_keyboardDetallFragment, bundle)
        }
        b4.setOnClickListener {
            val bundle = bundleOf("textChars" to "ИЙКЛ")
            view.findNavController().navigate(R.id.action_keybordFragment_to_keyboardDetallFragment, bundle)
        }
        b5.setOnClickListener {
            val bundle = bundleOf("textChars" to "МНОП")
            view.findNavController().navigate(R.id.action_keybordFragment_to_keyboardDetallFragment, bundle)
        }
        b6.setOnClickListener {
            val bundle = bundleOf("textChars" to "РСТУ")
            view.findNavController().navigate(R.id.action_keybordFragment_to_keyboardDetallFragment, bundle)
        }
        b7.setOnClickListener {
            val bundle = bundleOf("textChars" to "ФХЧЦ")
            view.findNavController().navigate(R.id.action_keybordFragment_to_keyboardDetallFragment, bundle)
        }
        b8.setOnClickListener {
            val bundle = bundleOf("textChars" to "ШЩЪЫ")
            view.findNavController().navigate(R.id.action_keybordFragment_to_keyboardDetallFragment, bundle)
        }
        b9.setOnClickListener {
            val bundle = bundleOf("textChars" to "ЬЭЮЯ")
            view.findNavController().navigate(R.id.action_keybordFragment_to_keyboardDetallFragment, bundle)
        }
        b_send.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, listenerText?.getAllText())
                type = "text/plain"
            }
            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listenerText=listener?.getISendCharOnClear()
        init(view)
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
}