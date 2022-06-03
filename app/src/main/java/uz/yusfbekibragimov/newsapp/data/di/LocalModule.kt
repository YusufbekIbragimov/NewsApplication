package uz.yusfbekibragimov.newsapp.data.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.yusfbekibragimov.newsapp.data.pref.MyPreference
import javax.inject.Singleton

/**
 * Created by Ibragimov Yusufbek
 * Date: 24/05/2022
 * Project: News App
 **/

@Module
@InstallIn(SingletonComponent::class)
class LocalModule {

    @[Provides Singleton]
    fun getSharedPreferences(@ApplicationContext context: Context): MyPreference = MyPreference(context)

}