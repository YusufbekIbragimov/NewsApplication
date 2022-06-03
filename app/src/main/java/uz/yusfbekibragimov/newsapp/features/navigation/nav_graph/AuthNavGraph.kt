package uz.yusfbekibragimov.newsapp.features.navigation.nav_graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import uz.yusfbekibragimov.newsapp.features.navigation.AUTH_ROUTE
import uz.yusfbekibragimov.newsapp.features.navigation.Screen
import uz.yusfbekibragimov.newsapp.features.screen.splash.SplashScreen

/**
 * Created by Ibragimov Yusufbek
 * Date: 16.02.2022
 * Project: ComposeNavigation
 **/

fun NavGraphBuilder.authNavGraph(
    navController: NavHostController
) {

    navigation(
        startDestination = Screen.SPLASH.route,
        route = AUTH_ROUTE
    ) {
        composable(route = Screen.SPLASH.route) {
            SplashScreen(navController = navController)
        }
    }

}