package uz.yusfbekibragimov.newsapp.features.screen.splash

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.VectorPainter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.accompanist.pager.*
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dev.chrisbanes.snapper.ExperimentalSnapperApi
import uz.yusfbekibragimov.newsapp.R
import uz.yusfbekibragimov.newsapp.features.navigation.Screen
import uz.yusfbekibragimov.newsapp.utils.pages
import kotlin.math.absoluteValue

/**
 * Created by Ibragimov Yusufbek
 * Date: 18/05/2022
 * Project: News App
 **/

@OptIn(ExperimentalPagerApi::class)
@Composable
fun SplashScreen(navController: NavHostController) {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val pagerState = rememberPagerState()

            val systemUiController = rememberSystemUiController()
            systemUiController.setSystemBarsColor(
                color = pages[pagerState.currentPage].color,
                darkIcons = pagerState.currentPage == 2
            )

            Surface(modifier = Modifier.fillMaxSize()) {
                BubblePagerContent(pagerState = pagerState)
            }
            /*Text(
                modifier = Modifier.clickable {
                    navController.navigate(Screen.HOME.route)
                },
                text = stringResource(R.string.splash_screen),
                fontSize = 18.sp,
                color = Color.Black
            )*/
        }
    }

}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun BubblePagerContent(pagerState: PagerState) {
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        BubblePager(
            pagerState = pagerState,
            pageCount = pages.size,
            modifier = Modifier.fillMaxSize(),
            bubbleColors = pages.map { it.color }
        ) { page ->
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(120.dp))
                Image(
                    modifier = Modifier.size(250.dp),
                    painter = painterResource(id = pages[page].content.imageId),
                    contentDescription = "Image"
                )
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = pages[page].content.text,
                    style = MaterialTheme.typography.h3,
                    color = if (page == 2) Color.Black else Color.White,
                    textAlign = TextAlign.Center,
                    softWrap = true,
                    modifier = Modifier.padding(horizontal = 40.dp)
                )
            }
        }
        PagerTopAppBar(
            page = pagerState.currentPage,
            modifier = Modifier.wrapContentSize()
        )
    }
}

@Composable
fun PagerTopAppBar(page: Int, modifier: Modifier = Modifier) {
    TopAppBar(
        title = { },
        backgroundColor = Color.Transparent,
        elevation = 0.dp,
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "Left Icon",
                )
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "Menu icon",
                )
            }
        },
        contentColor = if (page == 2) Color.Black else Color.White,
        modifier = modifier
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun BubblePager(
    pagerState: PagerState,
    pageCount: Int,
    modifier: Modifier = Modifier,
    bubbleMinRadius: Dp = 48.dp,
    bubbleMaxRadius: Dp = 12000.dp,
    bubbleBottomPadding: Dp = 140.dp,
    bubbleColors: List<Color>,
    vector: ImageVector = ImageVector.vectorResource(id = R.drawable.ic_search),
    content: @Composable PagerScope.(Int) -> Unit
) {
    val icon = rememberVectorPainter(vector)
    val isDragged by pagerState.interactionSource.collectIsDraggedAsState()
    val arrowBubbleRadius by animateDpAsState(
        targetValue = if (pagerState.shouldHideBubble(isDragged)) 0.dp else bubbleMinRadius,
        animationSpec = tween(350)
    )
    val arrowIconSize by animateDpAsState(
        targetValue = if (pagerState.shouldHideBubble(isDragged)) 0.dp else vector.defaultHeight,
        animationSpec = tween(350)
    )
    Box(modifier = modifier) {
        HorizontalPager(
            count = pageCount,
            state = pagerState,
            flingBehavior = bubblePagerFlingBehavior(pagerState),
            modifier = Modifier.drawBehind {
                drawRect(color = bubbleColors[pagerState.currentPage], size = size)
                val (radius, centerX) = calculateBubbleDimensions(
                    swipeProgress = pagerState.currentPageOffset,
                    easing = CubicBezierEasing(1f, 0f, .92f, .62f),
                    minRadius = bubbleMinRadius,
                    maxRadius = bubbleMaxRadius
                )
                drawBubble(
                    radius = radius,
                    centerX = centerX,
                    bottomPadding = bubbleBottomPadding,
                    color = pagerState.getBubbleColor(bubbleColors)
                )
                drawBubbleWithIcon(
                    radius = arrowBubbleRadius,
                    bottomPadding = bubbleBottomPadding,
                    color = pagerState.getNextBubbleColor(bubbleColors),
                    icon = icon,
                    iconSize = arrowIconSize
                )
            }
        ) { page ->
            content(page)
        }
    }
}

fun DrawScope.drawBubbleWithIcon(
    radius: Dp,
    bottomPadding: Dp,
    color: Color,
    icon: VectorPainter,
    iconSize: Dp
) {
    translate(size.width / 2) {
        drawCircle(
            radius = radius.toPx(),
            color = color,
            center = Offset(0.dp.toPx(), size.height - bottomPadding.toPx())
        )
        with(icon) {
            iconSize.toPx().let { iconSize ->
                translate(
                    top = size.height - bottomPadding.toPx() - iconSize / 2,
                    left = -(iconSize / 2) + 8 // adding a magic number to optically center the icon
                ) {
                    draw(size = Size(iconSize, iconSize))
                }
            }
        }
    }
}

fun DrawScope.drawBubble(
    radius: Dp,
    centerX: Dp,
    bottomPadding: Dp,
    color: Color
) {
    translate(size.width / 2) {
        drawCircle(
            color = color,
            radius = radius.toPx(),
            center = Offset(centerX.toPx(), size.height - bottomPadding.toPx())
        )
    }
}

fun calculateBubbleDimensions(
    swipeProgress: Float,
    easing: Easing,
    minRadius: Dp,
    maxRadius: Dp
): Pair<Dp, Dp> {
    // swipe value ranges between 0 to 1.0 for half of the swipe
    // and 1.0 to 0 for the other half of the swipe
    val swipeValue = lerp(0f, 2f, swipeProgress.absoluteValue)
    val radius = lerp(
        minRadius,
        maxRadius,
        easing.transform(swipeValue)
    )
    var centerX = lerp(
        0.dp,
        maxRadius,
        easing.transform(swipeValue)
    )
    if (swipeProgress < 0) {
        centerX = -centerX
    }
    return Pair(radius, centerX)
}

@OptIn(ExperimentalPagerApi::class, ExperimentalSnapperApi::class)
@Composable
fun bubblePagerFlingBehavior(pagerState: PagerState) =
    PagerDefaults.flingBehavior(
        state = pagerState,
        snapAnimationSpec = spring(dampingRatio = 1.9f, stiffness = 600f),
    )

@OptIn(ExperimentalPagerApi::class)
fun PagerState.getBubbleColor(bubbleColors: List<Color>): Color {
    val index = if (currentPageOffset < 0) {
        currentPage - 1
    } else nextSwipeablePageIndex
    return bubbleColors[index]
}

@OptIn(ExperimentalPagerApi::class)
fun PagerState.getNextBubbleColor(bubbleColors: List<Color>): Color {
    return bubbleColors[nextSwipeablePageIndex]
}

@OptIn(ExperimentalPagerApi::class)
fun PagerState.shouldHideBubble(isDragged: Boolean): Boolean = derivedStateOf {
    var b = false
    if (isDragged) {
        b = true
    }
    if (currentPageOffset.absoluteValue > 0.1) {
        b = true
    }
    b
}.value

/*
* Returns the next swipeable page index. If the last page is reached,
* then the index of the previous page is returned.
* */
@OptIn(ExperimentalPagerApi::class)
val PagerState.nextSwipeablePageIndex: Int
    get() = if ((currentPage + 1) == pageCount) currentPage - 1 else currentPage + 1

fun lerp(start: Float, end: Float, value: Float): Float {
    return start + (end - start) * value
}

