package com.example.whacamole.screens.third.domain

import android.content.Context
import androidx.activity.ComponentActivity
import com.example.whacamole.screens.first.domain.PREF_FILE_NAME
import com.example.whacamole.screens.first.domain.PREF_RECORD

fun saveRecord(score: Int, context: Context) {

    val sharedPreferences =
        context.getSharedPreferences(PREF_FILE_NAME, ComponentActivity.MODE_PRIVATE)
    val lastRecord = sharedPreferences.getInt(PREF_RECORD, 0)

    if (score > lastRecord) {
        val myEdit = sharedPreferences.edit()
        myEdit.putInt(PREF_RECORD, score)
        myEdit.apply()
    }
}