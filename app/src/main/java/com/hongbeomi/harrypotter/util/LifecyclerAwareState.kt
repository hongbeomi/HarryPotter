package com.hongbeomi.harrypotter.util

import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import kotlinx.coroutines.flow.Flow

@Composable
fun <T> getLifecycleAwareState(
    flow: Flow<T>,
    initialValue: T,
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current
): State<T> {
    return remember(flow, lifecycleOwner) {
        flow.flowWithLifecycle(lifecycleOwner.lifecycle)
    }.collectAsState(initialValue)
}