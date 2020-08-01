package com.dicoding.agungnovian.model.data
import org.json.JSONException
import org.json.JSONObject
import java.io.Serializable

data class AttackData (
    var id: String = "",
    var name: String = "",
    var text: String = "",
    var damage: String = "",
    var convertedEnergyCost: Int = 0,
    var cost: ArrayList<String>? = null
) : Serializable {
    fun fromJson(data : JSONObject) : AttackData {
        try {
            this.id = if (data.has("id")) data["id"].toString() else ""
            this.name = if (data.has("name")) data["name"].toString() else ""
            this.text = if (data.has("text")) data["text"].toString() else ""
            this.damage = if (data.has("damage")) data["damage"].toString() else ""
            if (data.has("cost")){
                val jsonArray = data.getJSONArray("cost")
                this.cost = ArrayList()
                for (i in 0 until jsonArray.length()) {
                    val item = jsonArray[i].toString()
                    this.cost!!.add(item)
                }
            }
            this.convertedEnergyCost = if (data.has("convertedEnergyCost")) data["convertedEnergyCost"].toString().toInt() else 0
            return this
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return this
    }
    fun toJson() : String {
        val jsonObject = JSONObject()
        jsonObject.put("id", this.id)
        return jsonObject.toString()
    }
}