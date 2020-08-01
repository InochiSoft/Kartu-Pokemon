package com.dicoding.agungnovian.model.data
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.Serializable

data class CardData (
    var id: String = "",
    var name: String = "",
    var nationalPokedexNumber: Int = 0,
    var imageUrl: String = "",
    var imageUrlHiRes: String = "",
    var supertype: String = "",
    var subtype: String = "",
    var evolvesFrom: String = "",
    var hp: String = "",
    var number: String = "",
    var artist: String = "",
    var rarity: String = "",
    var series: String = "",
    var set: String = "",
    var setCode: String = "",
    var ability: AbilityData? = null,
    var types: ArrayList<String>? = null,
    var text: ArrayList<String>? = null,
    var retreatCost: ArrayList<String>? = null,
    var attacks: ArrayList<AttackData>? = null,
    var resistances: ArrayList<ValueData>? = null,
    var weaknesses: ArrayList<ValueData>? = null
) : Serializable {
    fun fromJson(json : String) : CardData {
        try {
            val jsonObject = JSONObject(json)
            if (jsonObject.has("cards")) {
                if (!jsonObject.isNull("cards")) {
                    val data = jsonObject.getJSONObject("cards")
                    return fromJson(data)
                }
            } else {
                return fromJson(jsonObject)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return this
    }
    fun fromJson(data : JSONObject) : CardData {
        try {
            this.id = if (data.has("id")) data["id"].toString() else ""
            this.name = if (data.has("name")) data["name"].toString() else ""
            this.nationalPokedexNumber = if (data.has("nationalPokedexNumber")) data["nationalPokedexNumber"].toString().toInt() else 0
            this.imageUrl = if (data.has("imageUrl")) data["imageUrl"].toString() else ""
            this.imageUrlHiRes = if (data.has("imageUrlHiRes")) data["imageUrlHiRes"].toString() else ""
            this.supertype = if (data.has("supertype")) data["supertype"].toString() else ""
            this.subtype = if (data.has("subtype")) data["subtype"].toString() else ""
            this.evolvesFrom = if (data.has("evolvesFrom")) data["evolvesFrom"].toString() else ""
            this.hp = if (data.has("hp")) data["hp"].toString() else ""
            this.number = if (data.has("number")) data["number"].toString() else ""
            this.artist = if (data.has("artist")) data["artist"].toString() else ""
            this.rarity = if (data.has("rarity")) data["rarity"].toString() else ""
            this.series = if (data.has("series")) data["series"].toString() else ""
            this.set = if (data.has("set")) data["set"].toString() else ""
            this.setCode = if (data.has("setCode")) data["setCode"].toString() else ""
            if (data.has("types")){
                val jsonArray = data.getJSONArray("types")
                this.types = ArrayList()
                for (i in 0 until jsonArray.length()) {
                    val item = jsonArray[i].toString()
                    this.types!!.add(item)
                }
            }
            if (data.has("text")){
                val jsonArray = data.getJSONArray("text")
                this.text = ArrayList()
                for (i in 0 until jsonArray.length()) {
                    val item = jsonArray[i].toString()
                    this.text!!.add(item)
                }
            }
            if (data.has("retreatCost")){
                val jsonArray = data.getJSONArray("retreatCost")
                this.retreatCost = ArrayList()
                for (i in 0 until jsonArray.length()) {
                    val item = jsonArray[i].toString()
                    this.retreatCost!!.add(item)
                }
            }
            if (data.has("resistances")){
                val jsonArray = data.getJSONArray("resistances")
                this.resistances = ArrayList()
                for (i in 0 until jsonArray.length()) {
                    val item = JSONObject(jsonArray[i].toString())
                    this.resistances!!.add(ValueData().fromJson(item))
                }
            }
            if (data.has("weaknesses")){
                val jsonArray = data.getJSONArray("weaknesses")
                this.weaknesses = ArrayList()
                for (i in 0 until jsonArray.length()) {
                    val item = JSONObject(jsonArray[i].toString())
                    this.weaknesses!!.add(ValueData().fromJson(item))
                }
            }
            if (data.has("attacks")){
                val jsonArray = data.getJSONArray("attacks")
                this.attacks = ArrayList()
                for (i in 0 until jsonArray.length()) {
                    val item = JSONObject(jsonArray[i].toString())
                    this.attacks!!.add(AttackData().fromJson(item))
                }
            }
            if (data.has("ability")){
                val ability = data.getJSONObject("ability")
                this.ability = AbilityData().fromJson(ability)
            }

            return this
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return this
    }
    fun toJson() : String {
        val jsonObject = JSONObject()
        jsonObject.put("id", this.id)
        jsonObject.put("name", this.name)
        jsonObject.put("nationalPokedexNumber", this.nationalPokedexNumber)
        jsonObject.put("imageUrl", this.imageUrl)
        jsonObject.put("imageUrlHiRes", this.imageUrlHiRes)
        jsonObject.put("supertype", this.supertype)
        jsonObject.put("subtype", this.subtype)
        jsonObject.put("evolvesFrom", this.evolvesFrom)
        jsonObject.put("hp", this.hp)
        jsonObject.put("number", this.number)
        jsonObject.put("artist", this.artist)
        jsonObject.put("rarity", this.rarity)
        jsonObject.put("series", this.series)
        jsonObject.put("set", this.set)
        jsonObject.put("setCode", this.setCode)
        jsonObject.put("types", this.types)
        jsonObject.put("resistances", this.resistances)
        jsonObject.put("weaknesses", this.weaknesses)
        jsonObject.put("text", this.text)
        jsonObject.put("ability", this.ability)
        return jsonObject.toString()
    }
}