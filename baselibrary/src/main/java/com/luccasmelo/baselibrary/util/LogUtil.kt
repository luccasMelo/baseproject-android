package com.luccasmelo.baselibrary.util

import android.util.Log

class LogUtil {

    fun String.log(tag: String = "TAG") {
        Log.v(tag, this)
    }

    fun String.logE(tag: String = "TAG") {
        Log.e(tag, this)
    }

}