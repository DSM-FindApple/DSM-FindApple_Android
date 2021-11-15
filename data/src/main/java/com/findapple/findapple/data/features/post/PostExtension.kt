package com.findapple.findapple.data.features.post

import android.net.Uri
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

fun Uri.toMultipartPart(): MultipartBody.Part {
    val file = File(this.path!!)
    val fileBody = file.asRequestBody("image/jpeg".toMediaTypeOrNull())
    return MultipartBody.Part.createFormData("images", this.path!!, fileBody)
}

fun List<Uri>.toMultipart(): List<MultipartBody.Part> =
    this.map { it.toMultipartPart() }
