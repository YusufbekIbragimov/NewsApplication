package uz.yusfbekibragimov.newsapp.utils

import com.squareup.moshi.JsonAdapter

/**
 * Created by Ibragimov Yusufbek
 * Date: 23/05/2022
 * Project: News App
 **/

fun <T> T?.toJson(adapter: JsonAdapter<T>): String? {
    if (this == null) return null

    return adapter.toJson(this)
}

fun <T> String?.fromJson(adapter: JsonAdapter<T>): T? {
    if (this == null) return null

    return adapter.fromJson(this)
}