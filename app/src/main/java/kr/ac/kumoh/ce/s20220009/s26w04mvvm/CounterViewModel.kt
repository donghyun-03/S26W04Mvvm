package kr.ac.kumoh.ce.s20220009.s26w04mvvm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CounterViewModel : ViewModel() {
//    private var _counter by mutableStateOf(CounterModel(0))
    private val _counter = MutableStateFlow(CounterModel(0))

    // Mutable로 아예 바꿀 수 없도록 변환해서 넘겨줌 (복사해서 넘겨줌)
    val counter = _counter.asStateFlow()

    private val _events = MutableSharedFlow<String>()
    val events = _events.asSharedFlow()
    fun incrementCounter() {
        _counter.value = _counter.value.increment()

        if (_counter.value.count == 5) {
            viewModelScope.launch {
                _events.emit("카운터 5에 도달")
            }
        }
    }

    fun decrementCounter() {
        _counter.value = _counter.value.decrement()
    }

    fun resetCounter() {
        _counter.value = _counter.value.reset()

        viewModelScope.launch {
            _events.emit("카운터 초기화")
        }
    }
}