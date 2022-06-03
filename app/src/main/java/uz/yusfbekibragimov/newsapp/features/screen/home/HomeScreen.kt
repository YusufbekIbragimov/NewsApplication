package uz.yusfbekibragimov.newsapp.features.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import uz.yusfbekibragimov.newsapp.R
import uz.yusfbekibragimov.newsapp.features.component.NewsItem

/**
 * Created by Ibragimov Yusufbek
 * Date: 18/05/2022
 * Project: News App
 **/

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeVM) {

    val newsState by viewModel.newsListLiveData.observeAsState(emptyList())
    viewModel.getNews("us", "business")

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                Column {
                    val list = listOf<String>(
                        "Top",
                        "Business",
                        "Network",
                        "Media",
                        "Business",
                        "Network",
                        "Media"
                    )
                    var selectedIndex by remember { mutableStateOf(0) }

                    Row(
                        modifier = Modifier.height(56.dp),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.ic_search),
                            contentDescription = stringResource(R.string.search),
                            modifier = Modifier
                                .padding(start = 4.dp)
                                .fillMaxHeight()
                                .aspectRatio(1f)
                                .padding(vertical = 6.dp, horizontal = 4.dp)
                                .clip(CircleShape)
                                .clickable {}
                                .padding(vertical = 8.dp),
                            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
                        )

                        Text(
                            text = stringResource(id = R.string.app_name),
                            modifier = Modifier.padding(end = 16.dp),
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 18.sp,
                            color = MaterialTheme.colorScheme.primary
                        )

                    }

                    ScrollableTabRow(
                        selectedTabIndex = selectedIndex,
                        containerColor = Color.Transparent,
                        divider = {},
                        edgePadding = 4.dp
                    ) {
                        list.forEachIndexed { index, s ->
                            Tab(
                                selected = index == selectedIndex,
                                onClick = {
                                    selectedIndex = index
                                },
                                modifier = Modifier.clip(RoundedCornerShape(20.dp))
                            ) {
                                Text(
                                    text = s,
                                    modifier = Modifier
                                        .padding(vertical = 8.dp, horizontal = 6.dp)
                                        .clip(RoundedCornerShape(20.dp))
                                        .background(MaterialTheme.colorScheme.secondaryContainer)
                                        .padding(vertical = 8.dp, horizontal = 16.dp)
                                )
                            }
                        }
                    }

                }
            }

            items(newsState) { data ->
                NewsItem(data)
            }
        }
    }

}