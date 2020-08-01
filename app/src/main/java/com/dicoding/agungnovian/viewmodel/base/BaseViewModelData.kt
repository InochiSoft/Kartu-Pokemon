package lib.infonet.chat.viewmodel.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModelData<T> : ViewModel() {
    private var data: MutableLiveData<T>? = null

    private fun init(){
        if (data == null) {
            data = MutableLiveData()
        }
    }

    fun getData(): LiveData<T>? {
        init()
        return data
    }

    fun setData(item: T) {
        init()
        data?.postValue(item)
    }
}