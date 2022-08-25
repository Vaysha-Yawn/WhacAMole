package com.example.whacamole.screens.first.domain

import android.content.Context
import androidx.activity.ComponentActivity

const val PREF_FILE_NAME = "WhackAMoleRecord"
const val PREF_RECORD = "record"

fun getRecord(context: Context):Int {
    val sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, ComponentActivity.MODE_PRIVATE)
    return sharedPreferences.getInt(PREF_RECORD, 0)
}