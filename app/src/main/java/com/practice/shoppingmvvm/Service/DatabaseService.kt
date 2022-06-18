package com.practice.shoppingmvvm.Service

import android.content.Context
import androidx.room.*
import com.practice.shoppingmvvm.dao.Dao
import com.practice.shoppingmvvm.modal.ShoppingList

@Database(
    exportSchema = false,
    version = 1,
    entities = [ShoppingList::class]
)
abstract class DatabaseService:RoomDatabase() {
    abstract fun dao(): Dao

    companion object {
        private val instance: DatabaseService? = null
        private val lock = Any()

        operator fun invoke(contaxt: Context) = instance ?: synchronized(lock) {
            instance ?: buildDatabase(contaxt)
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                DatabaseService::class.java,"Weather.db"
            ).build()

    }
}