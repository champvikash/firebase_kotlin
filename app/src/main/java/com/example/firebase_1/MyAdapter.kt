package com.example.firebase_1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MyAdapter(private val context: Context,private val userList: ArrayList<User>)
    : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.user_item,
            parent,false)
        return MyViewHolder(itemView)

    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


        val currentitem = userList[position]
        holder.firstName.text = currentitem.firstName
        holder.lastName.text = currentitem.lastName
        holder.age.text = currentitem.age

        // for image

        Glide.with(context)
            .load(currentitem.icon)
            .into(holder.userImage)

    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val firstName : TextView = itemView.findViewById(R.id.tvfirstName)
        val lastName : TextView = itemView.findViewById(R.id.tvlastName)
        val age : TextView = itemView.findViewById(R.id.tvage)
        var userImage : ImageView  = itemView.findViewById(R.id.icon)

    }
}