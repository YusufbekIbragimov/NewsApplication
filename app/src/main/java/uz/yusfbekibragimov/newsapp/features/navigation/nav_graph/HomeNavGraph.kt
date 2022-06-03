package uz.yusfbekibragimov.newsapp.features.navigation.nav_graph

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import uz.yusfbekibragimov.newsapp.features.navigation.HOME_ROUTE
import uz.yusfbekibragimov.newsapp.features.navigation.Screen
import uz.yusfbekibragimov.newsapp.features.screen.detail.DetailScreen
import uz.yusfbekibragimov.newsapp.features.screen.home.HomeScreen
import uz.yusfbekibragimov.newsapp.features.screen.home.HomeVM

/**
 * Created by Ibragimov Yusufbek
 * Date: 16.02.2022
 * Project: ComposeNavigation
 **/

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.homeNavGraph(
    navController: NavHostController,
    viewModel: HomeVM
) {
    navigation(
        startDestination = Screen.HOME.route,
        route = HOME_ROUTE
    ){
        composable(route = Screen.HOME.route) {
            EnterAnimation {
                HomeScreen(navController = navController, viewModel = viewModel)
            }
        }
        composable(route = Screen.DETAIL.route) {
            EnterAnimation {
                DetailScreen(navController = navController)
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun EnterAnimation(content: @Composable () -> Unit) {
    AnimatedVisibility(
        visible = true,
        enter = fadeIn(initialAlpha = 0.2f) + slideInHorizontally(),
        exit = fadeOut(targetAlpha = 0.2f) + slideOutHorizontally(),
        content = content,
        initiallyVisible = false
    )
}