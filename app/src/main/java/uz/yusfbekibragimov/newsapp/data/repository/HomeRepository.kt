package uz.yusfbekibragimov.newsapp.data.repository

import kotlinx.coroutines.flow.Flow
import uz.yusfbekibragimov.newsapp.data.model.top_headlines.TopHeadlinesResponse

/**
 * Created by Ibragimov Yusufbek
 * Date: 18/05/2022
 * Project: News App
 **/

interface HomeRepository {
    fun getNews(country: String, category: String): Flow<TopHeadlinesResponse>
}