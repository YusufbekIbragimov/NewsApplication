package uz.yusfbekibragimov.newsapp.features.screen.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

/**
 * Created by Ibragimov Yusufbek
 * Date: 24/05/2022
 * Project: News App
 **/

@Composable
fun DetailScreen(navController: NavHostController) {
    Surface {
        Column {
            Text(text = "Hello")
            Text(text = "Hello")
            Text(text = "Hello")
            Text(text = "Hello")
            Text(text = "Hello")
            Text(text = "Hello")
        }
    }
}