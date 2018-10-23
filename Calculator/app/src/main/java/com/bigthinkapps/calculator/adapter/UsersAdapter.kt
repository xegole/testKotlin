package com.bigthinkapps.calculator.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bigthinkapps.calculator.LoginActivity.Companion.TYPE_ADMIN
import com.bigthinkapps.calculator.R
import com.bigthinkapps.calculator.adapter.viewholder.UserViewHolder
import com.bigthinkapps.calculator.model.Store
import com.bigthinkapps.calculator.model.UserList

class UsersAdapter(private val items: ArrayList<Store>) :
        RecyclerView.Adapter<UserViewHolder>() {

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

    fun addMoreItems(list: ArrayList<Store>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(viewHolder: UserViewHolder, position: Int) {
        viewHolder.setData(items[position])
    }

    override fun getItemViewType(position: Int): Int {
        return 101//items[position].typeUser
    }
}