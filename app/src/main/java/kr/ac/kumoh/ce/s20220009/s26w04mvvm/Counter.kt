package kr.ac.kumoh.ce.s20220009.s26w04mvvm

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Counter(
    modifier: Modifier = Modifier,
    count: Int,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit,
    onReset: () -> Unit,
) {
    var expanded by rememberSaveable {mutableStateOf(false)}

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
                    onIncrement()
                }
            ) {
                Text("+", fontSize = 30.sp)
            }

            if (expanded) {

                Button(
                    onClick = {
                        onDecrement()
                        expanded = false
                    }
                ) {
                    Text("-", fontSize = 30.sp)
                }

                Button(
                    onClick = {
                        onReset()
                        expanded = false
                    }
                ) {
                    Text("0", fontSize = 30.sp)
                }
            }

            else{
                Button(
                    onClick = {
                        expanded = true
                    }
                ) {
                    Text("...", fontSize = 30.sp)
                }
            }
        }
    }
}