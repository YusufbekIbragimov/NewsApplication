package uz.yusfbekibragimov.newsapp.features.screen.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import uz.yusfbekibragimov.newsapp.domain.usecase.home.HomeUseCase
import uz.yusfbekibragimov.newsapp.features.navigation.nav_graph.SetUpNavGraph
import uz.yusfbekibragimov.newsapp.features.screen.home.HomeVM
import uz.yusfbekibragimov.newsapp.features.ui.theme.NewsAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel by viewModels<HomeVM>()

        setContent {
            NewsAppTheme {
                navController = rememberNavController()
                SetUpNavGraph(navController = navController,viewModel)
            }
        }
    }

}