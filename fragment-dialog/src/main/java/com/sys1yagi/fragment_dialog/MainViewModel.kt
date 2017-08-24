package com.sys1yagi.fragment_dialog

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val dialogOk = MutableLiveData<Unit>()
    val dialogCancel = MutableLiveData<Unit>()
}

