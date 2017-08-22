package com.sys1yagi.aac_viewmodel_with

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item_notification.view.*

class NotificationAdapter : RecyclerView.Adapter<NotificationAdapter.Holder>() {

    class Holder(root: View) : RecyclerView.ViewHolder(root)

    var items = emptyList<String>()

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.item.text = "Item $position"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            Holder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_notification, parent, false))
}
