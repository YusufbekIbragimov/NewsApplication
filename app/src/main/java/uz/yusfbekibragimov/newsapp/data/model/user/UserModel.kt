package uz.yusfbekibragimov.newsapp.data.model.user

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Created by Ibragimov Yusufbek
 * Date: 23/05/2022
 * Project: News App
 **/

@JsonClass(generateAdapter = true)
data class UserModel(
    @Json(name = "id")
    val id: Int,
    @Json(name = "created_at")
    val createdAt: String,
    @Json(name = "updated_at")
    val updatedAt: String,
    @Json(name = "deleted_at")
    val deletedAt: String?,
    @Json(name = "first_name")
    val firstName: String,
    @Json(name = "last_name")
    val lastName: String,
    @Json(name = "phone")
    val phone: String,
    @Json(name = "token")
    val token: String
)