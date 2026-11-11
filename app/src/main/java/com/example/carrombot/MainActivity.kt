
package com.example.carrombot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CarromBotApp()
        }
    }
}

@Composable
fun CarromBotApp() {
    var status by remember {
        mutableStateOf("Bot Ready")
    }

    var angle by remember {
        mutableFloatStateOf(45f)
    }

    var power by remember {
        mutableFloatStateOf(50f)
    }

    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                "CARROM BOT ASSISTANT",
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(Modifier.height(25.dp))

            Text("Status: $status")

            Spacer(Modifier.height(20.dp))

            Text("Angle: ${angle.toInt()}°")

            Slider(
                value = angle,
                onValueChange = { angle = it },
                valueRange = 0f..360f
            )

            Text("Power: ${power.toInt()}%")

            Slider(
                value = power,
                onValueChange = { power = it },
                valueRange = 0f..100f
            )

            Button(onClick = {
                status = "Board analysis demo ready"
            }) {
                Text("Analyze Board")
            }

            Button(onClick = {
                status = "Shot: ${angle.toInt()}° / ${power.toInt()}%"
            }) {
                Text("Calculate Shot")
            }

            OutlinedButton(onClick = {
                status = "Bot Stopped"
            }) {
                Text("STOP")
            }
        }
    }
}
