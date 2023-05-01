package com.example.bubbleanimation.model

import androidx.compose.animation.core.Easing
import androidx.compose.ui.geometry.Offset

data class BubbleData(
    val start: Offset,
    val end: Offset,
    val radius: Float,
    val duration: Long,
    val easing: Easing
)
