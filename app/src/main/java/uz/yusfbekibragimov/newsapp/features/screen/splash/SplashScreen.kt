package uz.yusfbekibragimov.newsapp.features.screen.splash

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import uz.yusfbekibragimov.newsapp.R
import uz.yusfbekibragimov.newsapp.features.navigation.HOME_ROUTE
import uz.yusfbekibragimov.newsapp.features.navigation.Screen

/**
 * Created by Ibragimov Yusufbek
 * Date: 18/05/2022
 * Project: News App
 **/

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
            Text(
                modifier = Modifier.clickable {
                    navController.navigate(Screen.HOME.route)
                },
                text = stringResource(R.string.splash_screen),
                fontSize = 18.sp,
                color = Color.Black
            )
        }
    }

}