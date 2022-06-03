package uz.yusfbekibragimov.newsapp.data.pref

import android.content.Context
import androidx.core.content.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import uz.yusfbekibragimov.newsapp.data.model.user.UserModel
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Ibragimov Yusufbek
 * Date: 23/05/2022
 * Project: News App
 **/

@Singleton
class MyPreference @Inject constructor(
    @ApplicationContext context: Context
) {

    companion object {
        const val PREF_NAME = "PREF_NAME"
    }

    private val preference = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    private var token: String? = null

    private var user: UserModel?
        set(value) {
            preference.edit {

            }
        }
        get() {
            return null
        }

}