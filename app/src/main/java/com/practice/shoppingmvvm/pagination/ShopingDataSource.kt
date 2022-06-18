package com.practice.shoppingmvvm.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.practice.shoppingmvvm.Service.DatabaseService
import com.practice.shoppingmvvm.modal.ShoppingList
import com.practice.shoppingmvvm.repositries.ShopingRepositries

 abstract  class  ShopingDataSource(val respo: ShopingRepositries) : PagingSource<Int, ShoppingList>() {

    override fun getRefreshKey(state: PagingState<Int, ShoppingList>): Int? {
        TODO("Not yet implemented")
    }
}