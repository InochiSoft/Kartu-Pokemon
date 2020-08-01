package com.dicoding.agungnovian.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import com.dicoding.agungnovian.model.data.CardData
import com.dicoding.agungnovian.model.proxy.CardProxy
import com.dicoding.agungnovian.model.service.VolleyCallback
import lib.infonet.chat.viewmodel.base.BaseViewModelList
import org.json.JSONArray
import org.json.JSONObject

class CardsViewModelList : BaseViewModelList<CardData>() {
    fun list(context : Context): LiveData<MutableList<CardData>>? {
        CardProxy.list(context, object : VolleyCallback {
            override fun onSuccess(result: Any?) {
                val json : String = result.toString()
                val jsonObject = JSONObject(json)
                if (jsonObject.has("cards")) {
                    if (!jsonObject.isNull("cards")) {
                        val cards = jsonObject.getJSONArray("cards")
                        for (i in 0 until cards.length()) {
                            val item = cards.getJSONObject(i)
                            val card : CardData = CardData().fromJson(item)
                            add(card)
                        }
                    }
                }
            }
        })
        return getData()
    }
}