package ru.valyabulanova.weathercolor.common

import androidx.lifecycle.LifecycleCoroutineScope
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.MutableSharedFlow

fun <T> Flow<T>.observe(lifecycleScope: LifecycleCoroutineScope, value: FlowCollector<T>) {
    lifecycleScope.launchWhenStarted {
        this@observe.collect(value)
    }
}

fun <T> MutableSingleEventFlow() = MutableSharedFlow<T>(
    replay = 0,
    extraBufferCapacity = 1,
    onBufferOverflow = BufferOverflow.DROP_OLDEST
)