package com.example.whacamole.screens.third.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.whacamole.R
import com.example.whacamole.screens.third.domain.saveRecord
import com.example.whacamole.theme.DarkGreen
import com.example.whacamole.theme.Pumpkin


@Composable
fun ThirdScreen(nav: MutableState<Int>, score: MutableState<Int>) {

    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Score
        Text(text = stringResource(id = R.string.yourScore), style = MaterialTheme.typography.body1)
        Text(text = score.value.toString(), style = MaterialTheme.typography.h2)

        // Play again button
        Button(
            onClick = { nav.value = 2 },
            colors = ButtonDefaults.buttonColors(backgroundColor = Pumpkin),
            modifier = Modifier.padding(top = 10.dp)
        ) {
            Text(
                text = stringResource(id = R.string.playAgain),
                style = MaterialTheme.typography.h4
            )
        }

        // Menu button
        Button(
            onClick = { nav.value = 1 },
            colors = ButtonDefaults.buttonColors(backgroundColor = DarkGreen),
            modifier = Modifier.padding(top = 10.dp)
        ) {
            Text(text = stringResource(id = R.string.menu), style = MaterialTheme.typography.h5)
        }
    }

    saveRecord(score.value, LocalContext.current)
}