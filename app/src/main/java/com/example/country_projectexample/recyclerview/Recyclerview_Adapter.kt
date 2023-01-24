package com.example.country_projectexample.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.country_projectexample.R

class Recyclerview_Adapter(val context: Context, private val item: ArrayList<Recyclerview_Model>
) : RecyclerView.Adapter<Recyclerview_Adapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.item_country,parent,false)
        return Recyclerview_Adapter.ViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = item[position]
        val listener = View.OnClickListener { it ->
            Toast.makeText(it.context, "Clicked -> name : ${item.enName_Official.toString()}, capital : ${item.capital} name_eng : ${item.korName_Common?.toString()} capital : ${item.capital}",Toast.LENGTH_SHORT).show()
        }
        holder.apply {
            bind(listener, item, context)
            itemView.tag = item
        }

    }

    override fun getItemCount(): Int {
        return item.size
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var view: View = v

        fun bind(listener: View.OnClickListener, item: Recyclerview_Model, context: Context) {
            view.findViewById<TextView>(R.id.name_Kor).text = item.korName_Common
            view.findViewById<TextView>(R.id.name_Eng).text = item.enName_Official
            view.findViewById<TextView>(R.id.capital).text = item.capital
            Glide.with(context)
                .load(item.flags)
                .into(view.findViewById(R.id.imageView))

        }

    }




}
