package com.group7.unitconverter

class BackEndApi {
    val conversionRepository = ConversionRepository()
    val converter = Converter()

     /* pass in the category like "temperature" or "weight". This function will return the
        supported units for that category. Use the list that is returned to populate the
        "Start Unit" selection list on the conversion screen.
     */
    fun getUnitsForType(type: String) : List<String> =
        conversionRepository.getUnitsForType(type)

    /*  pass in the "Start Unit" that the user selected, and also
        pass in the category like "temperature" or "weight". This function will return the
        units that can be converted to from the starting unit. Use the list that is returned
        to populate the
        "End Unit" selection list on the conversion screen.
     */
    fun getUnitsThatCanBeConvertedTo(startUnit: String, type: String) : List<String> =
        conversionRepository.getUnitsThatCanBeConvertedTo(startUnit, type)

    /* After getting the user's input, call this function to get the output, the value converted into
        the desired unit.
        Pass in the value that the user wants to convert into another unit, and pass in the type of
        units that are being converted, like "temperature" or "weight" units. Also, pass in the
        start unit the user wants to convert from and the end unit the user wants to convert to.
        this function will return a number after converting it into the end unit. Display the number
        to the user.
     */
    fun convert(startValue: Float, type: String, startUnit: String, endUnit: String) : Float =
        converter.convert(startValue,type,startUnit,endUnit)
}