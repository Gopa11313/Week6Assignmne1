package com.example.week6assignment1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.week6assignment1.R
import com.example.week6assignment1.model.user

class HomeAdapter(
//        val listUser: ArrayList<user>
        private val data: List<user>,
):RecyclerView.Adapter<HomeAdapter.HomeViewholder>() {
    private var listUser: MutableList<user> = data as MutableList<user>

    inner class HomeViewholder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(user: user, index: Int) {
            val image = view.findViewById<ImageView>(R.id.imageView)
            val name = view.findViewById<TextView>(R.id.name)
            val age = view.findViewById<TextView>(R.id.age)
            val address = view.findViewById<TextView>(R.id.address)
            val gender = view.findViewById<TextView>(R.id.gender)
            val imageView = view.findViewById<Button>(R.id.imageView2)
            name.text = user.name.toString()
            age.text = user.age.toString()
            address.text = user.address.toString()
            Glide.with(view.context)
                    .load(user.image.toString())
                    .into(image)
            gender.text= user.gender.toString()
            imageView.setOnClickListener {deleteItem(index)}
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewholder {
       val view=LayoutInflater.from(parent.context)
           .inflate(R.layout.for_home, parent, false)
        return HomeViewholder(view)
    }

    override fun onBindViewHolder(holder: HomeViewholder, position: Int) {
        holder.bind(listUser[position], position)
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    fun deleteItem(index: Int){
        listUser.removeAt(index)
        notifyDataSetChanged()
    }

}