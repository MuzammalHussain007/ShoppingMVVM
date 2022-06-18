package com.practice.shoppingmvvm.viewModal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.practice.shoppingmvvm.repositries.ShopingRepositries

class ShopingViewModalFactory(private val respo:ShopingRepositries) :ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShopingListViewModal::class.java))
        {
            return ShopingListViewModal(respo) as T
        }
        throw IllegalArgumentException("Unable to construct viewmodel")

    }
}