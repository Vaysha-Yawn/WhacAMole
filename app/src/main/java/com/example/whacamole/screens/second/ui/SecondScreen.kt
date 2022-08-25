package com.example.whacamole.screens.second.ui


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.whacamole.R
import com.example.whacamole.domain.nextScreen
import kotlinx.coroutines.delay


@Composable
fun SecondScreen(nav: MutableState<Int>, score: MutableState<Int>) {

    val currentTime = remember { mutableStateOf(30L * 1000L) }

    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .padding(20.dp)
    ) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            Column {

                Timer(currentTime, nav)

                // Score
                Text(
                    text = (stringResource(id = R.string.score) + " " + score.value.toString()),
                    style = MaterialTheme.typography.h3
                )
            }
        }

        GridHole(score)
    }
}


@Composable
fun Timer(currentTime: MutableState<Long>, nav: MutableState<Int>) {

    LaunchedEffect(key1 = currentTime.value) {
        delay(1000L)
        currentTime.value -= 1000L
    }

    Text(
        text = (stringResource(id = R.string.timeLeft) + " "
                + (currentTime.value / 1000).toString()),
        style = MaterialTheme.typography.h3
    )

    if (currentTime.value == 0L) {
        nextScreen(nav)
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GridHole(score: MutableState<Int>) {

    val numberHoleWithMole = remember { mutableStateOf(getRandomNumberHole()) }

    LazyVerticalGrid(
        GridCells.Fixed(3), modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        items(9) {
            Hole(it, numberHoleWithMole, score)
        }
    }
}


fun getRandomNumberHole(): Int {
    return (0..8).random()
}