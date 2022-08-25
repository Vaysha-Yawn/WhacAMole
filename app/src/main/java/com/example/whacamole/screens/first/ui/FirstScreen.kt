package com.example.whacamole.screens.first.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.whacamole.domain.nextScreen
import com.example.whacamole.screens.first.domain.getRecord


@Composable
fun FirstScreen(nav: MutableState<Int>) {

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Title
        Text(
            text = (stringResource(id = com.example.whacamole.R.string.title)),
            style = MaterialTheme.typography.h1,
            modifier = Modifier.padding(bottom = 20.dp)
        )

        // Mole picture
        Image(
            painterResource(id = com.example.whacamole.R.drawable.mole_for_first_screen),
            contentDescription = "mole",
            modifier = Modifier
                .sizeIn(80.dp, 80.dp, 480.dp, 480.dp)
        )

        // Play button
        Image(painterResource(id = com.example.whacamole.R.drawable.play),
            contentDescription = "play",
            modifier = Modifier
                .offset(y = (-80).dp)
                .clickable { nextScreen(nav) }
                .sizeIn(40.dp, 40.dp, 150.dp, 150.dp)
        )

        // Actual record
        val record = getRecord(LocalContext.current)

        Text(
            text = (stringResource(id = com.example.whacamole.R.string.record) + " " + record.toString()),
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier
                .padding(top = 20.dp)
                .offset(y = (-80).dp)
        )

        // Rule
        Text(
            text = (stringResource(id = com.example.whacamole.R.string.rule)),
            style = MaterialTheme.typography.body1,
            modifier = Modifier
                .offset(y = (-60).dp)
                .padding(horizontal = 40.dp),
            textAlign = TextAlign.Center
        )
    }
}