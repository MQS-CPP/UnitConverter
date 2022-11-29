package com.group7.unitconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

val TAG = "MAIN_ACTIVITY"

class MainActivity : AppCompatActivity() {
    val backEndApi = BackEndApi()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        functionTesting()
    }

    fun functionTesting() {
        val type = "temperature"
        val unitsForType = backEndApi.getUnitsForType(type)
        val selectedStartUnit = unitsForType[0]
        val unitsThatCanBeConvertedTo = backEndApi.getUnitsThatCanBeConvertedTo(selectedStartUnit, type)
        val selectedEndUnit = unitsThatCanBeConvertedTo[1]
        val startValue = 2.0f
        val endValue = backEndApi.convert(startValue,type,selectedStartUnit,selectedEndUnit)
        Log.d(TAG, endValue.toString())
    }


}