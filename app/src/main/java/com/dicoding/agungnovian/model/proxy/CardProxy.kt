package com.dicoding.agungnovian.model.proxy
import android.content.Context
import com.dicoding.agungnovian.model.service.VolleyCallback
import com.dicoding.agungnovian.model.service.WebService

object CardProxy{
    fun list(context : Context, callback: VolleyCallback){
        val method = "cards"
        WebService.get(context, method, callback)
    }

    fun get(context : Context, id: String, callback: VolleyCallback){
        val method = "cards/$id"
        WebService.get(context, method, callback)
    }
}