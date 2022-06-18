package com.practice.shoppingmvvm

import android.app.Dialog
import android.os.Bundle
import android.view.Window
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.work.*
import com.practice.shoppingmvvm.Service.DatabaseService
import com.practice.shoppingmvvm.WorkManager.TestShopingWorker
import com.practice.shoppingmvvm.databinding.ActivityMainBinding
import com.practice.shoppingmvvm.modal.ShoppingList
import com.practice.shoppingmvvm.repositries.ShopingRepositries
import com.practice.shoppingmvvm.viewModal.ShopingListViewModal
import com.practice.shoppingmvvm.viewModal.ShopingViewModalFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity(), KodeinAware {
    override val kodein by kodein()
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModal: ShopingListViewModal
    private lateinit var recyclerView: RecyclerView
    private val factory: ShopingViewModalFactory by instance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModal = ViewModelProvider(this, factory)[ShopingListViewModal::class.java]
        binding.recyclarView.layoutManager = LinearLayoutManager(this)
        viewModal.getShoping().observe(this) {
            binding.recyclarView.adapter = ShoppingAdapter(viewModal, it as ArrayList<ShoppingList>)
        }

        binding.fab.setOnClickListener {
            openDialog()
        }
    }

    private fun openDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.add_dialog)
        val name = dialog.findViewById(R.id.etName) as EditText
        var amount = dialog.findViewById<EditText>(R.id.etAmount)

        val yesBtn = dialog.findViewById<TextView>(R.id.tvAdd)
        val noBtn = dialog.findViewById<TextView>(R.id.tvCancel)
        yesBtn.setOnClickListener {
            viewModal.insert(
                ShoppingList(
                    name.text.toString(),
                    amount = amount.text.toString().toInt()
                )
            )
            dialog.dismiss()
        }
        noBtn.setOnClickListener { dialog.dismiss() }
        dialog.show()

    }
}