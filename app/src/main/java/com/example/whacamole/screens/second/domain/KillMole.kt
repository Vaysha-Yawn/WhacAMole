package com.example.whacamole.screens.second.domain

import androidx.compose.runtime.MutableState
import androidx.lifecycle.LifecycleCoroutineScope
import com.example.whacamole.screens.second.ui.getRandomNumberHole
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun killMole(
    numberHoleWithMole: MutableState<Int>,
    score: MutableState<Int>,
    plusAlpha: MutableState<Float>,
    scope: LifecycleCoroutineScope
) {
    numberHoleWithMole.value = getRandomNumberHole()
    score.value++

    // Animation +1
    scope.launch {
        plusAlpha.value = 1f
        delay(500L)
        plusAlpha.value = 0f
    }
}