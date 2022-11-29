package com.group7.unitconverter

class Converter {
    private val conversionRepository = ConversionRepository() //conversion repository should be changed to a singleton

    fun getConversionFactor(type: String, startUnit: String, endUnit: String) : Float? {
        var conversionFactor : Float? = null
        val conversions = conversionRepository.getConversionsOfType(type)
        for (conversion in conversions) {
            if (conversion.startUnit == startUnit) {
                if (conversion.endUnit == endUnit) {
                    conversionFactor = conversion.conversionFactor
                    break
                }
            } else if (conversion.startUnit == endUnit) {
                if (conversion.endUnit == startUnit) {
                    conversionFactor = 1 / conversion.conversionFactor
                    break
                }
            }
        }
        return conversionFactor
    }

    fun convert(startValue: Float, type: String, startUnit: String, endUnit: String) : Float {
        val conversionFactor = getConversionFactor(type, startUnit,endUnit)
            ?: throw RuntimeException("A conversion does not exist between those units")
        return startValue * conversionFactor
    }
}