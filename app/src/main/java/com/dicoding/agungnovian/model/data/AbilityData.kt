package com.dicoding.agungnovian.model.data
import org.json.JSONException
import org.json.JSONObject
import java.io.Serializable

data class AbilityData (
    var name: String = "",
    var text: String = "",
    var type: String = ""
) : Serializable {
    fun fromJson(data : JSONObject) : AbilityData {
        try {
            this.type = if (data.has("type")) data["type"].toString() else ""
            this.name = if (data.has("name")) data["name"].toString() else ""
            this.text = if (data.has("text")) data["text"].toString() else ""
            return this
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return this
    }
    fun toJson() : String {
        val jsonObject = JSONObject()
        jsonObject.put("name", this.name)
        jsonObject.put("type", this.type)
        jsonObject.put("text", this.text)
        return jsonObject.toString()
    }
}