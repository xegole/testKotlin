package com.bigthinkapps.calculator.adapter.viewholder

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import com.bigthinkapps.calculator.DetailUserActivity
import com.bigthinkapps.calculator.model.UserList
import kotlinx.android.synthetic.main.user_item_adapter.view.*

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    init {

    }

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