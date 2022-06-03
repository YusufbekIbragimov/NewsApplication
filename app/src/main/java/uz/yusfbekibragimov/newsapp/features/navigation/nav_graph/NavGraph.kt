package uz.yusfbekibragimov.newsapp.features.navigation.nav_graph

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import uz.yusfbekibragimov.newsapp.features.navigation.AUTH_ROUTE
import uz.yusfbekibragimov.newsapp.features.navigation.ROOT_ROUTE
import uz.yusfbekibragimov.newsapp.features.screen.home.HomeVM
import uz.yusfbekibragimov.newsapp.features.screen.main.MainVM

/**
 * Created by Ibragimov Yusufbek
 * Date: 16.02.2022
 * Project: ComposeNavigation
 **/

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SetUpNavGraph(
    navController: NavHostController,
    viewModel: HomeVM
) {
    NavHost(
        navController = navController,
        startDestination = AUTH_ROUTE,
        route = ROOT_ROUTE
    ) {
        homeNavGraph(navController = navController,viewModel)
        authNavGraph(navController = navController)
    }
}