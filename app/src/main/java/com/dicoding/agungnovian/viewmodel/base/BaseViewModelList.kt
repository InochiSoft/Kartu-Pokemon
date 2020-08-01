package lib.infonet.chat.viewmodel.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModelList<T> : ViewModel() {
    private var data: MutableLiveData<MutableList<T>>? = null

    private fun init(){
        if (data == null) {
            data = MutableLiveData()
        } else {
            if (data?.value == null) {
                data?.value = ArrayList()
            }
        }
    }

    fun getData(): LiveData<MutableList<T>>? {
        init()
        return data
    }

    fun clear() {
        init()
        data?.value?.clear()
    }

    fun add(item: T) {
        init()
        data?.value?.add(item)
    }

    fun setData(items: ArrayList<T>) {
        init()
        data?.value?.addAll(items)
    }

    fun addAll(items: ArrayList<T>) {
        init()
        data?.value?.addAll(items)
    }
}