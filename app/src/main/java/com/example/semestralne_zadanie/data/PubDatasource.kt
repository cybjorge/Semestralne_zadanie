package com.example.semestralne_zadanie.data

import android.content.Context
import android.util.Log
import com.example.semestralne_zadanie.model.AllPubs
import com.example.semestralne_zadanie.model.Pub
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

class PubDatasource {

    fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val json: String
        try {
            json = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return json
    }

    fun loadPubsFromJson(jsonFile: String): MutableList<Pub>{
        val allPubs: MutableList<Pub> = ArrayList()

        val gson = Gson()
        val listAllPubsDetail = object : TypeToken<AllPubs>() {}.type

        val pubs: AllPubs = gson.fromJson(jsonFile,listAllPubsDetail)
        pubs.elements.forEachIndexed{idx, pub -> Log.i("data", "> Item $idx:\n${pub.tags.get(key = "name")}")}
        pubs.elements.forEachIndexed{idx, pub -> allPubs.add(pub)}
        return allPubs
    }
}