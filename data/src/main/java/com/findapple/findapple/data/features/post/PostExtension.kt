package com.findapple.findapple.data.features.post

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

fun File.toMultipartPart(): MultipartBody.Part {
    val fileBody = this.asRequestBody("image/jpeg".toMediaTypeOrNull())
    return MultipartBody.Part.createFormData("images", this.path!!, fileBody)
}

fun List<File>.toMultipart(): List<MultipartBody.Part> =
    this.map { it.toMultipartPart() }
