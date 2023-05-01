# Bubble Animation
This is a Compose-based animation that displays bubbles of different sizes moving around the screen.


https://user-images.githubusercontent.com/102308110/235490552-9f63972f-7dc2-4ed9-b26a-2a6a5f0ae5cd.mp4


## Usage
To use the animation, you can call the BubbleAnimation() composable function and pass in the following parameters:

- colors: a list of Color objects representing the gradient colors of the bubbles.
- bubbleCount: an integer value representing the number of bubbles to display.
- offsetX: a float value representing the maximum horizontal distance a bubble can move.
- offsetY: a float value representing the maximum vertical distance a bubble can moves.

```
BubbleAnimation(
    listOf(Color.Yellow, Color.Gray),
    bubbleCount = 13,
    offsetX = 900f,
    offsetY = 750f,
)
```

## Preview
You can preview the animation using the BubbleAnimationPreview() composable function:
```
@Preview(showBackground = true)
@Composable
fun BubbleAnimationPreview() {
    BubbleAnimation(
        colors = listOf(Color.Yellow, Color.Gray),
        bubbleCount = 3,
        offsetX = 800f,
        offsetY = 400f,
}
```
