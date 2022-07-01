package uz.yusfbekibragimov.newsapp.utils

import uz.yusfbekibragimov.newsapp.R
import androidx.compose.ui.graphics.Color

/**
 * Created by Ibragimov Yusufbek
 * Date: 20/05/2022
 * Project: News App
 **/

class Const {
    companion object {
        const val BASE_URL = "https://newsapi.org/v2/"
        const val API_KEY = "097d4c4b113f46b1bb7439c5287597e1"
    }
}

val pages = listOf(
    Page(
        id = 1,
        content = PageContent(R.drawable.ic_search, "Choose your interests"),
        color = Color(0xFF103E85)
    ),
    Page(
        id = 2,
        content = PageContent(R.drawable.ic_share, "Local news stories"),
        color = Color(0xFFD45D9E)
    ),
    Page(
        id = 3,
        content = PageContent(R.drawable.ic_show_more, "Save news stories"),
        color = Color(0xFFFFFFFF)
    ),
    Page(
        id = 4,
        content = PageContent(R.drawable.ic_search, "Bookmark your interests"),
        color = Color(0xFF52C6DF)
    ),
)

data class Page(
    val id: Int,
    val content: PageContent,
    val color: Color
)

data class PageContent(
    val imageId: Int,
    val text: String
)