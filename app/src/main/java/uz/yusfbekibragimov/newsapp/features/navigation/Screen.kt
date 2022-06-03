package uz.yusfbekibragimov.newsapp.features.navigation

const val AUTH_ROUTE = "AUTH_ROUTE"
const val HOME_ROUTE = "HOME_ROUTE"

const val ROOT_ROUTE = "ROOT_ROUTE"

sealed class Screen(var route: String) {

    object HOME: Screen("home_screen")
    object DETAIL: Screen("detail_screen")
    object ANALYSIS: Screen("analysis_screen")
    object NEWS: Screen("news_screen")
    object SPLASH: Screen("splash_screen")
    object SIGNUP: Screen("signup_screen")

}