package com.luccasmelo.baselibrary.util

import android.content.Context
import com.google.gson.Gson

class SharedPreferenceUtil {

    fun Any.save(context: Context, key: String? = null) {
        val prefsEditor =
            context.getSharedPreferences("javaClass.canonicalName", Context.MODE_PRIVATE).edit()
        val json = Gson().toJson(this)
        val simpleName = this::class.java.simpleName
        prefsEditor.putString(key ?: simpleName, json)
        prefsEditor.apply()
    }

    fun <T : Any> Any.load(context: Context, type: Class<T>, key: String? = null): T? {
        val prefs = context.getSharedPreferences("javaClass.canonicalName", Context.MODE_PRIVATE)
        val simpleName = key ?: type.simpleName
        val json = prefs.getString(simpleName, "{}")
        if (json == "{}" || json.isNullOrBlank()) {
            return null
        }
        return Gson().fromJson<T>(json, type)
    }
}