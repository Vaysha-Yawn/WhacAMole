package com.example.whacamole

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.whacamole.screens.first.ui.FirstScreen
import com.example.whacamole.screens.third.ui.ThirdScreen
import com.example.whacamole.screens.second.ui.SecondScreen
import com.example.whacamole.theme.WhacAMoleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lateinit var nav: MutableState<Int>
        lateinit var score: MutableState<Int>

        setContent {
            nav = remember { mutableStateOf(1) }
            score = remember { mutableStateOf(0) }

            WhacAMoleTheme {
                when (nav.value) {
                    1 -> {
                        FirstScreen(nav)
                    }
                    2 -> {
                        score.value = 0
                        SecondScreen(nav, score)
                    }
                    3 -> {
                        ThirdScreen(nav, score)
                    }
                }
            }
        }
    }
}