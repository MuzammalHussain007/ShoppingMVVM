package com.practice.shoppingmvvm.modal

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ShoppingList")
data class ShoppingList(
    @ColumnInfo(name="ItemName")
    var name:String,
    @ColumnInfo(name="ItemQuantity")
    var amount:Int
) {
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null
}