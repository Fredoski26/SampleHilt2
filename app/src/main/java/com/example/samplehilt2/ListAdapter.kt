package com.example.samplehilt2

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.samplehilt2.model.SampleUser

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyHolder>() {

    private var userList = emptyList<SampleUser>()

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_user_details, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val itemList = userList[position]

        val updateBtn = holder.itemView.findViewById<ConstraintLayout>(R.id.rowUpdate)

        /*initialize TextView*/
        val id = holder.itemView.findViewById<TextView>(R.id.id)
        val firstName = holder.itemView.findViewById<TextView>(R.id.displayFirstName)
        val lastName = holder.itemView.findViewById<TextView>(R.id.displayLastName)
        val email = holder.itemView.findViewById<TextView>(R.id.displayEmail)


        /*pass data to View*/
        id.text = itemList.id.toString()
        firstName.text = itemList.first_name
        lastName.text = itemList.last_name
        email.text = itemList.email

        val songBundle = Bundle()
        songBundle.putString("uId", itemList.id.toString())
        songBundle.putString("first", firstName.text.toString())
        songBundle.putString("last", lastName.text.toString())
        songBundle.putString("email", email.text.toString())


        updateBtn.setOnClickListener {
            holder.itemView.findNavController().navigate(R.id.updateFragment, songBundle)

        }
    }

    override fun getItemCount(): Int {
        return this.userList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(user: List<SampleUser>) {
        this.userList = user
        notifyDataSetChanged()
    }

}
