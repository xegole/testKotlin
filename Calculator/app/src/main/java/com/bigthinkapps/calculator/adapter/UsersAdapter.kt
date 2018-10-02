package com.bigthinkapps.calculator.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bigthinkapps.calculator.DetailUserActivity
import com.bigthinkapps.calculator.LoginActivity.Companion.TYPE_ADMIN
import com.bigthinkapps.calculator.R
import com.bigthinkapps.calculator.model.UserList
import kotlinx.android.synthetic.main.user_item_adapter.view.*

class UsersAdapter(
        val items: ArrayList<UserList>,
        val context: Context) : RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, typeView: Int): UserViewHolder {

        return if (typeView == TYPE_ADMIN) {
            val view = LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.admin_item_adapter, parent, false)
            UserViewHolder(view)
        } else {
            val view = LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.user_item_adapter, parent, false)
            UserViewHolder(view)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addMoreItems(list: ArrayList<UserList>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(viewHolder: UserViewHolder, position: Int) {
        viewHolder.setData(items[position])
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].typeUser
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        fun setData(userList: UserList) {
            itemView.labelName.text = userList.name
            itemView.labelLastName.text = userList.lastName
            itemView.labelAge.text = userList.age.toString()

            itemView.setOnClickListener { goToDetail(userList) }
        }

        private fun goToDetail(userList: UserList) {
            val intent = Intent(itemView.context, DetailUserActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable("user_list_extra", userList)
            intent.putExtras(bundle)
            itemView.context.startActivity(intent)
        }
    }
}