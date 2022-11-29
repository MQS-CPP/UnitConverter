package com.group7.unitconverter

data class Conversion(
    val type: String,
    val startUnit: String,
    val endUnit: String,
    val conversionFactor: Float,
)