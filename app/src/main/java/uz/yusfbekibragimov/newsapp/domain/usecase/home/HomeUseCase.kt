package uz.yusfbekibragimov.newsapp.domain.usecase.home

import kotlinx.coroutines.flow.Flow
import uz.yusfbekibragimov.newsapp.data.model.top_headlines.TopHeadlinesResponse

/**
 * Created by Ibragimov Yusufbek
 * Date: 23/05/2022
 * Project: News App
 **/

interface HomeUseCase {
    fun getNews(country: String, category: String): Flow<TopHeadlinesResponse>
}