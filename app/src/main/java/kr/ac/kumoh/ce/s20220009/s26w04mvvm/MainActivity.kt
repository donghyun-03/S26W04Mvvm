package kr.ac.kumoh.ce.s20220009.s26w04mvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.ac.kumoh.ce.s20220009.s26w04mvvm.ui.theme.S26W04MvvmTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            S26W04MvvmTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Counter(Modifier.padding(innerPadding))
    }
}

@Composable
fun Counter(
    modifier: Modifier = Modifier
) {
    var count by remember { mutableIntStateOf(0) }

    Column(
        modifier = modifier // Modifier 사용하면 윗 여백 없음
            .fillMaxSize()
            .padding(8.dp)
            .background(Color(0XFFE9F680)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = count.toString(),
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .background(Color(0xFFFE7A36)),
            color = Color.White,
            fontSize = 100.sp,
            textAlign = TextAlign.Center,
        )

        Row {
            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    count++
                }
            ) {
                Text("+", fontSize = 30.sp)
            }

            Button(
                onClick = {
                    count--
                }
            ) {
                Text("-", fontSize = 30.sp)
            }

            Button(
                onClick = {
                    count = 0
                }
            ) {
                Text("0", fontSize = 30.sp)
            }
        }
    }
}