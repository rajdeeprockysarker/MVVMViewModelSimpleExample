package com.raj.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.raj.viewmodel.storage.GetStaticValue
import com.raj.viewmodel.viwmodl.MainActivityViewModelOperation

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainActivityViewModelOperation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModelOperation::class.java)
        viewModel.user.observe(this, Observer {
            println("DEBUG: $it")
            Log.e("xfdfdfd",it.toString()
            );
        })

        viewModel.setUserId(1)

        Log.e(Companion.TAG, GetStaticValue.UserList[0].toString())
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}