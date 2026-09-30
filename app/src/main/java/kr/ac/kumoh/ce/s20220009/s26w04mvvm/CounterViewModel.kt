package kr.ac.kumoh.ce.s20220009.s26w04mvvm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private var _counter by mutableStateOf(CounterModel(0))
    val counter: CounterModel //immutable 한 객체를 만들어서 반환 ex) 1에서 1을 증가하면 1인 카운터를 버리고 2인 카운터를 반환
        get() = _counter

    fun incrementCount() {
        _counter = _counter.increment()
    }

    fun decrementCount() {
        _counter = _counter.decrement()
    }

    fun resetCount() {
        _counter = _counter.reset()
    }
}