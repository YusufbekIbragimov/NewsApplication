package uz.yusfbekibragimov.newsapp.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.yusfbekibragimov.newsapp.data.repository.HomeRepository
import uz.yusfbekibragimov.newsapp.data.repository.impl.HomeRepositoryImpl
import javax.inject.Singleton

/**
 * Created by Ibragimov Yusufbek
 * Date: 23/05/2022
 * Project: News App
 **/

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun getAppRepository(impl: HomeRepositoryImpl): HomeRepository

}