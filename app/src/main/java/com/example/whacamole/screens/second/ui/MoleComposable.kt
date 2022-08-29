package com.example.whacamole.screens.second.ui

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.example.whacamole.MainActivity
import com.example.whacamole.R
import com.example.whacamole.screens.second.domain.animateMoleEmerging
import com.example.whacamole.domain.getActivity
import com.example.whacamole.screens.second.domain.killMole


@Composable
fun Mole(
    numberHoleWithMole: MutableState<Int>,
    score: MutableState<Int>,
    plusAlpha: MutableState<Float>,
) {
    // Parameters for the animation of the emergence of the mole
    val yOffsetMoleState = remember { mutableStateOf((50).dp) }
    val alphaMoleState = remember { mutableStateOf(1f) }
    val yOffsetMole by animateDpAsState(
        targetValue = yOffsetMoleState.value,
        tween(100, 0, LinearEasing)
    )

    LaunchedEffect(key1 = true) {
        animateMoleEmerging(yOffsetMoleState, numberHoleWithMole, alphaMoleState)
    }

    // Mole
    val scope = rememberCoroutineScope()
    Image(
        painter = painterResource(id = R.drawable.mole),
        contentDescription = "",
        Modifier
            .fillMaxSize()
            .padding(top = 20.dp)
            .offset(y = yOffsetMole)
            .alpha(alphaMoleState.value)
            .clickable {
                killMole(numberHoleWithMole, score, plusAlpha, scope)
            }
    )
}