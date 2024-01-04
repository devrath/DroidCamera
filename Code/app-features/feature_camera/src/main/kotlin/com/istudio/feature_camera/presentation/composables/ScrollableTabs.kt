package com.istudio.feature_camera.presentation.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.istudio.feature_camera.presentation.emums.Tabs
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ScrollableTabs(
    modifier: Modifier = Modifier
) {

    val itemHorizontalPadding = 26.dp
    val backgroundShapeWidth = 62.dp
    val screenHalfWidth = LocalConfiguration.current.screenWidthDp.div(2).dp
    val horizontalContentPadding = screenHalfWidth.minus(itemHorizontalPadding.div(2))

    val coroutineScope = rememberCoroutineScope()
    val lazyListState = rememberLazyListState()
    val flingBehavior = rememberSnapFlingBehavior(lazyListState = lazyListState)

    val items = Tabs.values()


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Box(contentAlignment = Alignment.Center) {

            LazyRow(
                state = lazyListState,
                flingBehavior = flingBehavior,
                contentPadding = PaddingValues(horizontal = horizontalContentPadding),
                horizontalArrangement = Arrangement.spacedBy(26.dp)
            ){
                items(items.size) { index ->
                    Text(
                        text = items[index].name,
                        style = MaterialTheme.typography.labelLarge,
                        fontSize = 16.sp,
                        color = Color.White,
                        modifier = Modifier.padding(vertical = 20.dp).clickable {
                            coroutineScope.launch {
                                lazyListState.animateScrollToItem(index)
                            }
                        }
                    )
                }
            }
        }

    }

}

@Preview
@Composable
fun PreviewScrollableTabs(){
    ScrollableTabs()
}