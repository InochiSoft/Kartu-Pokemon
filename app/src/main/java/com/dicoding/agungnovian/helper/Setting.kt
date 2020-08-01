package lib.infonet.chat.helper

import android.content.Context
import android.content.SharedPreferences

class Setting(private var context: Context) {
    private var settings: SharedPreferences
    private var name: String = "infonet-chat"

    init {
        settings = context.getSharedPreferences(name, Context.MODE_PRIVATE)
    }

    fun setSetting(key: String?, value: String?) {
        val editor = settings.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun deleteSetting() {
        settings = context.getSharedPreferences(name, Context.MODE_PRIVATE)
        settings.edit().clear().apply()
    }

    private fun getSetting(key: String, defVal: String): String? {
        return settings.getString(key, defVal)
    }

    fun getSetting(key: String): String {
        return getSetting(key, "")?: ""
    }

    fun getIntSetting(strKey: String, defVal: Int): Int {
        val strValue = defVal.toString()
        val strSetting = getSetting(strKey, strValue)
        return strSetting!!.toInt()
    }

    fun getIntSetting(strKey: String): Int {
        val strSetting = getSetting(strKey)
        return strSetting.toInt()
    }

    fun setIntSetting(strKey: String?, defVal: Int) {
        val strValue = defVal.toString()
        setSetting(strKey, strValue)
    }

    fun getShortSetting(strKey: String, defVal: Short): Short {
        val strValue = defVal.toString()
        val strSetting = getSetting(strKey, strValue)
        return strSetting!!.toShort()
    }

    fun setShortSetting(strKey: String?, defVal: Short) {
        val strValue = defVal.toString()
        setSetting(strKey, strValue)
    }

    fun getLongSetting(strKey: String, defVal: Long): Long {
        val strValue = defVal.toString()
        val strSetting = getSetting(strKey, strValue)
        return strSetting!!.toLong()
    }

    fun getLongSetting(strKey: String): Long {
        val strSetting = getSetting(strKey)
        return strSetting.toLong()
    }

    fun setLongSetting(strKey: String?, defVal: Long) {
        val strValue = defVal.toString()
        setSetting(strKey, strValue)
    }
}
