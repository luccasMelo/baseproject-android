package com.luccasmelo.baselibrary.util

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

fun String.toAmount(hasCurrency: Boolean = false): String {
    val numberFormat = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
    if (this == ("0")) {
        val bigDecimal = BigDecimal(this).setScale(2, BigDecimal.ROUND_HALF_UP)
        return numberFormat.format(bigDecimal)
    }
    var format = numberFormat.format(java.lang.Double.valueOf(this) / 100)
    format = if (hasCurrency)
        format.replace("R$", "R$ ")
    else
        format.replace("R$", "")
    return format
}

public fun Long.toAmount(hasCurrency: Boolean = false): String {
    return this.toString().toAmount(hasCurrency)
}

