package com.example.module2_file2_ex8

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat.enableEdgeToEdge
import com.example.module2_file2_ex8.ui.theme.Module2_file2_ex6Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Module2_file2_ex6Theme {
                WaterTracker()
            }
        }
    }
}


@Composable
fun WaterTracker() {
    var waterCount by remember { mutableIntStateOf(0) }
    var streakDays by remember { mutableIntStateOf(0) }

    val primary = MaterialTheme.colorScheme.primary
    val onPrimary = MaterialTheme.colorScheme.onPrimary
    val accent = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.75f)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Трекер воды",
            fontSize = 28.sp,
            fontWeight = FontWeight.SemiBold,
            color = accent
        )

        Spacer(Modifier.height(24.dp))

        Text(
            text = "${waterCount} мл",
            fontSize = 44.sp,
            fontWeight = FontWeight.ExtraBold,
            color = accent
        )

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = { waterCount += 250 },
            colors = ButtonDefaults.buttonColors(containerColor = primary, contentColor = onPrimary),
            modifier = Modifier
                .testTag("addButton")
        ) {
            Text(text = "+250 мл", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(Modifier.height(24.dp))

        OutlinedButton(
            onClick = {
                if (waterCount >= 1500) {
                    streakDays += 1
                } else {
                    streakDays = 0
                }
                waterCount = 0
            },
            modifier = Modifier.testTag("finishDayButton")
        ) {
            Text("Завершить день")
        }

        Spacer(Modifier.height(16.dp))

        Text(
            text = "Серия дней ≥ 1500 мл: $streakDays",
            fontSize = 16.sp,
            modifier = Modifier.testTag("streakText"),
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Module2_file2_ex6Theme {
        WaterTracker()
    }
}
