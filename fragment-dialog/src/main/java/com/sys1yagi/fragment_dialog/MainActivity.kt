package com.sys1yagi.fragment_dialog

import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.LifecycleRegistryOwner
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity(), LifecycleRegistryOwner {

    override fun getLifecycle() = registry

    val registry = LifecycleRegistry(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button).setOnClickListener {
            HelloDialog.newInstance().show(supportFragmentManager, "hello")
        }

        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.dialogOk.observe(this, Observer {
            Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show()
        })
        viewModel.dialogCancel.observe(this, Observer {
            Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
        })
    }
}
