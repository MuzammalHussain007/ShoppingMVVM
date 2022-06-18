package com.practice.shoppingmvvm.viewModal

import androidx.lifecycle.ViewModel
import com.practice.shoppingmvvm.modal.ShoppingList
import com.practice.shoppingmvvm.repositries.ShopingRepositries
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShopingListViewModal(private val respositires:ShopingRepositries):ViewModel() {

    fun insert(item:ShoppingList) = CoroutineScope(Dispatchers.IO).launch {
        respositires.insertItem(item)
    }

    fun deleteItem(item:ShoppingList) = CoroutineScope(Dispatchers.IO).launch {
        respositires.deleteItem(item)
    }
    fun getShoping() = respositires.getAllItem()
}