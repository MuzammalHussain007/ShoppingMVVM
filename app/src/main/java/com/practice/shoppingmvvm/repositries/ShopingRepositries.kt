package com.practice.shoppingmvvm.repositries

import com.practice.shoppingmvvm.Service.DatabaseService
import com.practice.shoppingmvvm.modal.ShoppingList

class ShopingRepositries( val db:DatabaseService) {

    suspend fun insertItem(item:ShoppingList) = db.dao().insertItem(item)

    suspend fun deleteItem(item: ShoppingList) = db.dao().DeleteItem(item)

     fun getAllItem() = db.dao().getItem()

}