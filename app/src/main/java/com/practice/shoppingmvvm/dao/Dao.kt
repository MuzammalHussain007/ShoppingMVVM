package com.practice.shoppingmvvm.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.practice.shoppingmvvm.modal.ShoppingList

@Dao
interface Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertItem(shopingList:ShoppingList)
    @Query("SELECT * FROM ShoppingList")
    fun getItem():LiveData<List<ShoppingList>>
    @Delete
    suspend fun DeleteItem(shopingList: ShoppingList)

}