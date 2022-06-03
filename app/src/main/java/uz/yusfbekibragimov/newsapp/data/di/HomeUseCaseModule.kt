package uz.yusfbekibragimov.newsapp.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.yusfbekibragimov.newsapp.domain.usecase.home.HomeUseCase
import uz.yusfbekibragimov.newsapp.domain.usecase.home.impl.HomeUseCaseImpl
import javax.inject.Singleton

/**
 * Created by Ibragimov Yusufbek
 * Date: 23/05/2022
 * Project: News App
 **/

@Module
@InstallIn(ViewModelComponent::class)
interface HomeUseCaseModule {

    @Binds
    fun getRegisterUseCase(impl: HomeUseCaseImpl): HomeUseCase

}