package uz.yusfbekibragimov.newsapp.utils

/**
 * Created by Ibragimov Yusufbek
 * Date: 23/05/2022
 * Project: News App
 **/

import android.content.Context
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.Response
import java.io.File

fun myLog(message: String, tag: String = "TTT") {
    Log.d(tag, message)
}

fun Fragment.showToast(message: String) {
    Toast.makeText(this.requireContext(), message, Toast.LENGTH_SHORT).show()
}

fun <T : ViewBinding> T.scope(block: T.() -> Unit) {
    block(this)
}

fun File.toRequestData(): MultipartBody.Part {
    val requestFile = this.asRequestBody("image/jpeg".toMediaTypeOrNull())
    return MultipartBody.Part.createFormData("avatar", name, requestFile)
}

fun View.hideKeyboard(): Boolean {
    try {
        val inputMethodManager =
            context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        return inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
    } catch (ignored: RuntimeException) {
    }
    return false
}

// file
fun File.toFormData(partName: String = "file"): MultipartBody.Part {
    val request = asRequestBody("multipart/form-data".toMediaTypeOrNull())
    return MultipartBody.Part.createFormData(partName, name, request)
}

suspend fun <T> resolveCall(call: suspend () -> Response<T>): Result<T> {
    val response = call()
    if (response.isSuccessful) {
        val data = response.body()
        return Result.success(checkNotNull(data))
    }

    return Result.failure(Throwable(response.errorBody()?.toString()))
}

// measurements
fun Context.px(dp: Float) =
    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics)

fun Context.px(dp: Int) = px(dp.toFloat()).toInt()

fun View.px(dp: Float) = context.px(dp)

fun View.px(dp: Int) = context.px(dp)

fun Fragment.px(dp: Float) = requireContext().px(dp)

fun Fragment.px(dp: Int) = requireContext().px(dp)