package com.neda.propertyapp.provider

import android.util.Log
import com.google.gson.Gson
import com.neda.propertyapp.api.PropertyAPI
import com.neda.propertyapp.model.PropertiesData
import com.neda.propertyapp.model.Property
import org.json.JSONObject
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.net.URL

// read properties info
// build http connection manually
class ManualParsing : PropertyAPI {
    override suspend fun getProperties(): PropertiesData {

        val url = URL("https://f213b61d-6411-4018-a178-53863ed9f8ec.mock.pstmn.io/properties")
        val connection = url.openConnection()
        connection.connect()

        val bufferedInputStream = BufferedInputStream(connection.getInputStream())
        val bufferReader: BufferedReader = bufferedInputStream.bufferedReader()
        val stringBuffer = StringBuffer()
        for (line:String in bufferReader.readLines()){
            stringBuffer.append(line)
        }
        Log.d("bufferReaderClose","bufferReader")
        bufferReader.close()
        val fullJson:String = stringBuffer.toString()

        val propertiesData = Gson().fromJson(fullJson, PropertiesData::class.java)

        return propertiesData
    }
}