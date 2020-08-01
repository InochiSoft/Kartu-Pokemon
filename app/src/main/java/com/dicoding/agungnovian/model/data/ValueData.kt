package com.dicoding.agungnovian.model.data
import org.json.JSONException
import org.json.JSONObject
import java.io.Serializable

data class ValueData (
    var type: String = "",
    var value: String = ""
) : Serializable {
    fun fromJson(data : JSONObject) : ValueData {
        try {
            this.type = if (data.has("type")) data["type"].toString() else ""
            this.value = if (data.has("value")) data["value"].toString() else ""
            return this
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return this
    }
    fun toJson() : String {
        val jsonObject = JSONObject()
        jsonObject.put("type", this.type)
        jsonObject.put("value", this.value)
        return jsonObject.toString()
    }
}