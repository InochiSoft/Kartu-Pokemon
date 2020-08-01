package com.dicoding.agungnovian.model.service

import android.content.Context
import android.widget.Toast
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.dicoding.agungnovian.helper.Constant

object WebService {
    fun post(context : Context, method : String, params : Map<String, String>, callback: VolleyCallback){
        val queue = Volley.newRequestQueue(context)
        val url = Constant.kURLWebservice + method
        val stringRequest: StringRequest =
            object : StringRequest( Method.POST, url,
                Response.Listener { response ->
                    callback.onSuccess(response)
                },
                Response.ErrorListener { error ->
                    Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show()
                }) {
                override fun getHeaders(): Map<String, String>? {
                    val headers: MutableMap<String, String> = HashMap()
                    headers["Content-Type"] = "application/x-www-form-urlencoded"
                    return headers
                }
                override fun getBodyContentType(): String {
                    return "application/json"
                }
                override fun getParams(): Map<String, String> {
                    return params
                }
            }

        stringRequest.retryPolicy = DefaultRetryPolicy(
            (Constant.kServerTimeout * 1000),
            DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        )
        queue.add(stringRequest)
    }

    fun get(context : Context, method : String, callback: VolleyCallback){
        val queue = Volley.newRequestQueue(context)
        val url = Constant.kURLWebservice + method
        val stringRequest: StringRequest =
            object : StringRequest( Method.GET, url,
                Response.Listener { response ->
                    callback.onSuccess(response)
                },
                Response.ErrorListener { error ->
                    Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show()
                }) {
                override fun getHeaders(): Map<String, String>? {
                    val headers: MutableMap<String, String> = HashMap()
                    headers["Content-Type"] = "application/x-www-form-urlencoded"
                    return headers
                }
                override fun getBodyContentType(): String {
                    return "application/json"
                }
            }

        stringRequest.retryPolicy = DefaultRetryPolicy(
            (Constant.kServerTimeout * 1000),
            DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        )
        queue.add(stringRequest)
    }
}