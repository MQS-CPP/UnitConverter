package com.group7.unitconverter

class ConversionRepository {


    private val conversionsInput = "temperature,unit1,unit2,2305.43/" +
            "temperature,unit1,unit3,34.2/" +
            "weight,unit1,unit2,12.7"

    fun getConversions(): List<Conversion> {
        val conversions = mutableListOf<Conversion>()
        val conversionData = conversionsInput //can be replaced with a file read if needed
        val conversionDataSeparated = conversionData.split("/")
        for (conversionString in conversionDataSeparated) {
            val conString = conversionString.split(",")
            val type = conString[0]
            val startUnit = conString[1]
            val endUnit = conString[2]
            val conversionFactor = conString[3].toFloat()
            conversions.add(Conversion(type,startUnit,endUnit,conversionFactor))
        }
        return conversions
    }

    fun getConversionsOfType(type: String) : List<Conversion> {
        val conversions = getConversions()
        val filteredConversions = mutableListOf<Conversion>()
        for (conversion in conversions) {
            if (conversion.type == type) {
                filteredConversions.add(conversion.copy())
            }
        }
        return filteredConversions
    }

    fun getConversionsWithUnit(startUnit: String, type: String) : List<Conversion> {
        val conversions = getConversionsOfType(type)
        val conversionsWithUnit = mutableListOf<Conversion>()
        for (conversion in conversions) {
            if (conversion.startUnit == startUnit || conversion.endUnit == startUnit) {
                conversionsWithUnit.add(conversion)
            }
        }
        return conversionsWithUnit
    }

    fun getUnitsThatCanBeConvertedTo(startUnit: String, type: String) : List<String> {
        val conversionsWithUnit = getConversionsWithUnit(startUnit,type)
        return conversionsWithUnit
            .map { if (it.startUnit == startUnit) it.endUnit else it.startUnit }
            .toSet()
            .toList()
    }

    fun getUnitsForType(type: String) : List<String> {
        val filteredConversions = getConversionsOfType(type)
        val unitSet = mutableSetOf<String>()
        for (conversion in filteredConversions) {
            val startUnit = conversion.startUnit
            val endUnit = conversion.endUnit
            unitSet.add(startUnit)
            unitSet.add(endUnit)
        }
        return unitSet.toList()
    }


}