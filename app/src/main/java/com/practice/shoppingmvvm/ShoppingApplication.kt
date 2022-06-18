package com.practice.shoppingmvvm

import android.app.Application
import androidx.work.*
import com.practice.shoppingmvvm.Service.DatabaseService
import com.practice.shoppingmvvm.WorkManager.TestShopingWorker
import com.practice.shoppingmvvm.repositries.ShopingRepositries
import com.practice.shoppingmvvm.viewModal.ShopingViewModalFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import java.util.concurrent.TimeUnit


class ShoppingApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@ShoppingApplication))
        bind() from singleton { DatabaseService(instance())}
        bind() from singleton { ShopingRepositries(instance())}
        bind() from provider { ShopingViewModalFactory(instance())}
        innitWorkManager()


    }

    private fun innitWorkManager() {
        val mConstraints = Constraints
            .Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
//    ONE TIME WORK REQUEST
//        val mRequest =
//            OneTimeWorkRequest
//                .Builder(TestShopingWorker::class.java)
//                .setConstraints(mConstraints)
//                .build()

                val mRequest =
            PeriodicWorkRequest
                .Builder(TestShopingWorker::class.java,20,TimeUnit.MINUTES)
                .setConstraints(mConstraints)
                .build()
        WorkManager.getInstance(applicationContext).enqueue(mRequest)
//        val constraint = Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED)
//        var req =
//            PeriodicWorkRequest.Builder(TestShopingWorker::class.java, 5000, TimeUnit.MICROSECONDS)
//                .setConstraints(constraint)
//                .build()

    }


}
