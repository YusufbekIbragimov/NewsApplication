package uz.yusfbekibragimov.newsapp.data.remote.api

import retrofit2.http.GET
import retrofit2.http.Query
import uz.yusfbekibragimov.newsapp.data.model.top_headlines.TopHeadlinesResponse

/**
 * Created by Ibragimov Yusufbek
 * Date: 18/05/2022
 * Project: News App
 **/

interface NetworkService {

    @GET("top-headlines")
    suspend fun getNews(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apiKey") apiKey: String,
    ): TopHeadlinesResponse

}