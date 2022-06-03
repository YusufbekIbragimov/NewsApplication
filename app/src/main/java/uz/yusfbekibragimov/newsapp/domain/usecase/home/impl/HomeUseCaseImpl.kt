package uz.yusfbekibragimov.newsapp.domain.usecase.home.impl

import kotlinx.coroutines.flow.Flow
import uz.yusfbekibragimov.newsapp.data.model.top_headlines.TopHeadlinesResponse
import uz.yusfbekibragimov.newsapp.data.repository.HomeRepository
import uz.yusfbekibragimov.newsapp.domain.usecase.home.HomeUseCase
import javax.inject.Inject

/**
 * Created by Ibragimov Yusufbek
 * Date: 23/05/2022
 * Project: News App
 **/

class HomeUseCaseImpl @Inject constructor(
    private val repositoryImpl: HomeRepository
): HomeUseCase {

    override fun getNews(country: String, category: String): Flow<TopHeadlinesResponse> {
        return repositoryImpl.getNews(country, category)
    }

}