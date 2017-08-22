package com.sys1yagi.aac_viewmodel_with

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val left: MutableLiveData<Int> = MutableLiveData()

    val right: MutableLiveData<Int> = MutableLiveData()
}

