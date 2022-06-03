package uz.yusfbekibragimov.newsapp.features.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import uz.yusfbekibragimov.newsapp.R
import uz.yusfbekibragimov.newsapp.data.model.top_headlines.Article

/**
 * Created by Ibragimov Yusufbek
 * Date: 27/05/2022
 * Project: News App
 **/

@OptIn(ExperimentalCoilApi::class, ExperimentalMaterial3Api::class)
@Composable
fun NewsItem(article: Article) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {

        Card(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .wrapContentSize(),
            shape = RoundedCornerShape(8.dp)
        ) {

            Row {

                val painter =
                    rememberImagePainter(
                        data = article.urlToImage,
                        builder = {
                            transformations()
                        }
                    )

                Column(
                    modifier = Modifier
                        .height(144.dp)
                        .weight(1f)
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                ) {

                    Text(
                        text = article.title ?: "",
                        modifier = Modifier.padding(vertical = 4.dp),
                        maxLines = 2,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )

                    Text(
                        text = article.description.toString(),
                        modifier = Modifier.padding(vertical = 4.dp),
                        maxLines = 3,
                        fontSize = 13.sp
                    )

                }

                Image(
                    painter = painter,
                    contentDescription = "News Image 2",
                    modifier = Modifier
                        .padding(8.dp)
                        .width(118.dp)
                        .height(136.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop
                )

            }

            Row(
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier.padding(8.dp)
            ) {

                Text(
                    text = if (article.source?.name != null) article.source.name else "",
                    modifier = Modifier.padding(horizontal = 8.dp),
                    fontSize = 13.sp
                )

                Text(
                    text = if (article.publishedAt != null) article.publishedAt.substring(
                        11,
                        16
                    ) else "",
                    modifier = Modifier.padding(horizontal = 4.dp),
                    fontSize = 13.sp
                )

                Spacer(modifier = Modifier.weight(1f))

                Image(
                    painter = painterResource(id = R.drawable.ic_share),
                    contentDescription = "Icon",
                    modifier = Modifier
                        .size(36.dp)
                        .padding(4.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.onSecondary)
                        .clickable { }
                        .padding(6.dp),
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.secondary)
                )

                Image(
                    painter = painterResource(id = R.drawable.ic_show_more),
                    contentDescription = "Icon",
                    modifier = Modifier
                        .size(36.dp)
                        .padding(4.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.onSecondary)
                        .clickable { }
                        .padding(2.dp),
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.secondary)
                )

            }

        }

    }

}