package com.practice.shoppingmvvm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.practice.shoppingmvvm.modal.ShoppingList
import com.practice.shoppingmvvm.viewModal.ShopingListViewModal

class ShoppingAdapter(var viewModal: ShopingListViewModal, var list: ArrayList<ShoppingList>) :
    RecyclerView.Adapter<ShoppingAdapter.ShoppingHolder>() {

    class ShoppingHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemName = itemView.findViewById<TextView>(R.id.tvName)
        var itemQuantity = itemView.findViewById<TextView>(R.id.tvAmount)
        var deletebtn = itemView.findViewById<ImageView>(R.id.ivDelete)
        var incrementbtn = itemView.findViewById<ImageView>(R.id.ivPlus)
        var decrementbtn = itemView.findViewById<ImageView>(R.id.ivMinus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingHolder {
        return ShoppingHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.customitem, parent, false))
    }

    override fun onBindViewHolder(holder: ShoppingHolder, position: Int) {
        holder.itemName.text = list.get(position).name
        holder.itemQuantity.text = list.get(position).amount.toString()
    }

    override fun getItemCount(): Int {
     return list.size
    }
    


}



