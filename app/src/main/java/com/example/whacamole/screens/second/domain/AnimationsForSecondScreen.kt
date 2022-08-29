package com.example.whacamole.screens.second.domain

import androidx.compose.runtime.MutableState
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.whacamole.screens.second.ui.getRandomNumberHole
import kotlinx.coroutines.delay

suspend fun animateMoleEmerging(
    yOffsetMoleState: MutableState<Dp>,
    numberHoleWithMole: MutableState<Int>,
    alphaMoleState: MutableState<Float>
) {
    //Up animation
    alphaMoleState.value = 1f
    yOffsetMoleState.value = 0.dp
    val num1 = numberHoleWithMole.value

    delay(1000L)

    //Down animation
    yOffsetMoleState.value = (50).dp
    alphaMoleState.value = 0f
    numberHoleWithMole.value = getRandomNumberHole()
    val num2 = numberHoleWithMole.value

    if (num1 == num2) {
        delay(100L)
        animateMoleEmerging(yOffsetMoleState, numberHoleWithMole, alphaMoleState)
    }
}

suspend fun animatePlusOne(
    plusAlpha: MutableState<Float>,
) {
    plusAlpha.value = 1f
    delay(500L)
    plusAlpha.value = 0f
}