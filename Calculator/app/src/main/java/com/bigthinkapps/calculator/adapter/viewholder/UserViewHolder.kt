package com.bigthinkapps.calculator.adapter.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.bigthinkapps.calculator.entity.File
import kotlinx.android.synthetic.main.user_item_adapter.view.*

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    init {

    }

    fun setData(file: File) {
        itemView.labelName.text = file.name
        itemView.labelLastName.text = file.status
        itemView.labelAge.text = file.contentType

        //itemView.setOnClickListener { goToDetail(userList) }
    }

//    private fun goToDetail(userList: UserList) {
//        val intent = Intent(itemView.context, DetailUserActivity::class.java)
//        val bundle = Bundle()
//        bundle.putSerializable("user_list_extra", userList)
//        intent.putExtras(bundle)
//        itemView.context.startActivity(intent)
//    }
}