package uz.yusfbekibragimov.newsapp.features.screen.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import uz.yusfbekibragimov.newsapp.data.model.top_headlines.Article
import uz.yusfbekibragimov.newsapp.domain.usecase.home.HomeUseCase
import javax.inject.Inject

/**
 * Created by Ibragimov Yusufbek
 * Date: 18/05/2022
 * Project: News App
 **/

@HiltViewModel
class HomeVM @Inject constructor(
    private val useCase: HomeUseCase
) : ViewModel() {

    private val _newsListLiveData = MutableLiveData<List<Article>>()
    val newsListLiveData: LiveData<List<Article>> get() = _newsListLiveData

    fun getNews(country: String, category: String) {
        viewModelScope.launch {

            useCase.getNews(country, category).onEach {
                _newsListLiveData.value = it.articles
            }.launchIn(viewModelScope)

        }
    }

}