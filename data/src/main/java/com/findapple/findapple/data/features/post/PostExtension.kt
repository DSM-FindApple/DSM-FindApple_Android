package com.findapple.findapple.data.features.post

import android.net.Uri
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.toRequestBody

fun Uri.toMultipartPart(): MultipartBody.Part {
    val fileBody = this.path!!.toRequestBody("image/jpeg".toMediaTypeOrNull())
    return MultipartBody.Part.createFormData("images", this.path!!, fileBody)
}