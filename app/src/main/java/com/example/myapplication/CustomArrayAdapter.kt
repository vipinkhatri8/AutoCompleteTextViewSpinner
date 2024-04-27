package com.example.myapplication

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class CustomArrayAdapter(
    context: Context,
    var resource: Int,
    var items1: Int,
    private val items: List<String>
)
    : ArrayAdapter<String>(context, resource, items) {

    private var lastSelectedIndex = -1

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = LayoutInflater.from(context)
        val view = convertView ?: inflater.inflate(resource, parent, false)
        val textView = view.findViewById<TextView>(R.id.tv1)
       items1= textView.setText(items[position]).toString().toInt()

        // Set the text color

        if (position == lastSelectedIndex) {
            textView.setTextColor(Color.RED)
        } else {
            textView.setTextColor(Color.BLACK)
        }

        return view
    }

    fun updateLastSelectedIndex(index: Int) {
        lastSelectedIndex = index
        notifyDataSetChanged()
    }
}
