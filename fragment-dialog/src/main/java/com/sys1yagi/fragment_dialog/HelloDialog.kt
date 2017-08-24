package com.sys1yagi.fragment_dialog

import android.app.AlertDialog
import android.app.Dialog
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.DialogFragment


class HelloDialog : DialogFragment() {

    companion object {
        fun newInstance() = HelloDialog()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        val viewModel = ViewModelProviders.of(activity).get(MainViewModel::class.java)
        builder.setMessage("Hello")
                .setPositiveButton("Yes", { _, _ ->
                    viewModel.dialogOk.value = Unit
                })
                .setNegativeButton("Cancel", { _, _ ->
                    viewModel.dialogCancel.value = Unit
                })
        return builder.create()
    }
}
