package uz.yusfbekibragimov.newsapp.data.repository.impl

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.yusfbekibragimov.newsapp.data.model.top_headlines.TopHeadlinesResponse
import uz.yusfbekibragimov.newsapp.data.pref.MyPreference
import uz.yusfbekibragimov.newsapp.data.remote.api.NetworkService
import uz.yusfbekibragimov.newsapp.data.repository.HomeRepository
import uz.yusfbekibragimov.newsapp.utils.Const.Companion.API_KEY
import javax.inject.Inject

/**
 * Created by Ibragimov Yusufbek
 * Date: 18/05/2022
 * Project: News App
 **/

class HomeRepositoryImpl @Inject constructor(
    private val api: NetworkService,
    private val myPref: MyPreference
) : HomeRepository {

    override fun getNews(country: String, category: String): Flow<TopHeadlinesResponse> = flow {
        val response = api.getNews(country, category, API_KEY)
        emit(response)
    }

}