package kr.ac.kumoh.ce.s20220009.s26w04mvvm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CounterViewModel : ViewModel() {
//    private var _counter by mutableStateOf(CounterModel(0))
    private val _counter = MutableStateFlow(CounterModel(0))

    // Mutable로 아예 바꿀 수 없도록 변환해서 넘겨줌 (복사해서 넘겨줌)
    val counter = _counter.asStateFlow()

    fun incrementCount() {
        _counter.value = _counter.value.increment()
    }

    fun decrementCount() {
        _counter.value = _counter.value.decrement()
    }

    fun resetCount() {
        _counter.value = _counter.value.reset()
    }
}