package com.example.whacamole.domain

import androidx.compose.runtime.MutableState

fun nextScreen(nav: MutableState<Int>) {
    nav.value++
}