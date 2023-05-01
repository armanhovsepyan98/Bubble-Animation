package com.example.bubbleanimation

import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.bubbleanimation.model.BubbleData
import kotlin.random.Random

@Composable
fun BubbleAnimation(
    colors: List<Color>,
    bubbleCount: Int,
    modifier: Modifier = Modifier,
    offsetX: Float,
    offsetY: Float
) {
    val infiniteTransition = rememberInfiniteTransition()
    Box(
        modifier = modifier
    ) {
        val bubbles = remember {
            List(bubbleCount) {
                BubbleData(
                    start = Offset(
                        x = Random.nextFloat() * offsetX,
                        y = Random.nextFloat() * offsetY
                    ),
                    end = Offset(
                        x = Random.nextFloat() * offsetX,
                        y = Random.nextFloat() * offsetY
                    ),
                    duration = Random.nextLong(3000L, 10000L),
                    easing = when (Random.nextInt(3)) {
                        0 -> LinearEasing
                        1 -> FastOutSlowInEasing
                        else -> CubicBezierEasing(0.23f, 0.12f, 0.25f, 1.0f)
                    },
                    radius = Random.nextFloat() * 50f + 50f
                )
            }
        }

        bubbles.forEach { bubble ->
            val xValue by infiniteTransition.animateFloat(
                initialValue = bubble.start.x,
                targetValue = bubble.end.x,
                animationSpec = infiniteRepeatable(
                    animation = tween(bubble.duration.toInt(), easing = bubble.easing),
                    repeatMode = RepeatMode.Reverse
                )
            )
            val yValue by infiniteTransition.animateFloat(
                initialValue = bubble.start.y,
                targetValue = bubble.end.y,
                animationSpec = infiniteRepeatable(
                    animation = tween(bubble.duration.toInt(), easing = bubble.easing),
                    repeatMode = RepeatMode.Reverse
                )
            )
            Canvas(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                drawCircle(
                    brush = Brush.linearGradient(
                        colors,
                        start = Offset(xValue - 90, yValue),
                        end = Offset(xValue + 90, yValue)
                    ),
                    radius = bubble.radius,
                    center = Offset(xValue, yValue)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BubbleAnimationPreview() {
    BubbleAnimation(
        listOf(Color.Yellow,Color.Gray),
        bubbleCount = 13,
        offsetX = 900f,
        offsetY = 750f
    )
}