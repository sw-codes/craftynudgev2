package com.swright.craftynudgev2

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.swright.craftynudgev2.models.ColourChooser
import com.swright.craftynudgev2.models.FocalPoint
import com.swright.craftynudgev2.models.Theme

@Composable
fun CraftyNudgeApp() {
    val context = LocalContext.current
    val chosenColour = remember { mutableStateOf("") }
    val chosenColourRelationship = remember { mutableStateOf("") }
    val chosenTheme = remember {
        mutableStateOf("")
    }
    val chosenFocalPoint = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //title
        Text(
            text = "Crafty Nudge",
            fontSize = 32.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        //choose colour card
        Card(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = {
                    chosenColour.value = "#" + ColourChooser().chooseColour();
                    Toast.makeText(context, chosenColour.value, Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(8.dp)
            ) {
                Text(text = "generate a colour")
            }
            Text(
                text = chosenColour.value,
                fontSize = 24.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Card(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = {
                    chosenColourRelationship.value = ColourChooser().chooseColourRelationship()
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(8.dp)
            ) {
                Text(text = "generate a colour relationship")
            }
            Text(
                text = chosenColourRelationship.value,
                fontSize = 24.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Card(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = { chosenTheme.value = Theme().getTheme() },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(8.dp)
            ) {
                Text(text = "generate a theme")
            }
            Text(
                text = chosenTheme.value,
                fontSize = 24.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Card(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = { chosenFocalPoint.value = FocalPoint().chooseFocalPoint() },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(8.dp)
            ) {
                Text(text = "generate a focal point")
            }
            Text(
                text = chosenFocalPoint.value,
                fontSize = 24.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CraftyNudgePreview() {
    CraftyNudgeApp()
}