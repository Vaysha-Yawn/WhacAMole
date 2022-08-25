package com.example.whacamole.screens.second.ui

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.whacamole.R


@Composable
fun Hole(index: Int, numberHoleWithMole: MutableState<Int>, score: MutableState<Int>) {

    Box(
        Modifier
            .sizeIn(80.dp, 80.dp, 140.dp, 140.dp)
            .padding(10.dp)
    ) {
        // Hole
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                painter = painterResource(id = R.drawable.hole),
                contentDescription = "",
            )
        }

        // Transparency options for animation + 1
        val plusAlpha = remember { mutableStateOf(0f) }
        val alpha by animateFloatAsState(
            targetValue = plusAlpha.value,
            tween(500, 0, LinearEasing)
        )

        // Mole
        if (index == numberHoleWithMole.value) {
            Mole(numberHoleWithMole, score, plusAlpha)
        }

        // +1
        Box(
            modifier = Modifier
                .fillMaxSize(), contentAlignment = Alignment.TopEnd
        ) {
            Image(
                painter = painterResource(id = R.drawable.plus_one),
                contentDescription = "",
                modifier = Modifier.alpha(alpha)
            )
        }
    }
}
