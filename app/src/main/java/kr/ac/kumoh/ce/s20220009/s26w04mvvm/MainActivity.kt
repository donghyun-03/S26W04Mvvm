package kr.ac.kumoh.ce.s20220009.s26w04mvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.retain.retain
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.flow.count
import kr.ac.kumoh.ce.s20220009.s26w04mvvm.Counter
import kr.ac.kumoh.ce.s20220009.s26w04mvvm.ui.theme.S26W04MvvmTheme

class MainActivity : ComponentActivity() {
    private val counterViewModel: CounterViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            S26W04MvvmTheme {
                MainScreen(counterViewModel)
            }
        }
    }
}

@Composable
fun MainScreen(
    viewModel: CounterViewModel
) {
    val counterState by viewModel.counter.collectAsStateWithLifecycle()

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Counter(
            modifier = Modifier.padding(innerPadding),
            count = counterState.count,
            onIncrement = { viewModel.incrementCount() },
            onDecrement = { viewModel.decrementCount() },
            onReset = { viewModel.resetCount() },
        )
    }
}