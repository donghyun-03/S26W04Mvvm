package kr.ac.kumoh.ce.s20220009.s26w04mvvm

class CounterModel(
    private val _count: Int = 0
) {
    val count get()= _count

    fun increment() = CounterModel(_count + 1)
    fun decrement() = if (count > 0) CounterModel(_count - 1) else this
    fun reset() = CounterModel(0)
}