package com.findapple.findapple.app

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import java.io.ByteArrayOutputStream
import java.util.*

fun Bitmap?.toUri(context: Context): Uri {
    val bytes = ByteArrayOutputStream()
    this?.compress(Bitmap.CompressFormat.JPEG, 100, bytes)
    val path = MediaStore.Images.Media.insertImage(
        context.contentResolver,
        this,
        "Title" + "-" + Calendar.getInstance().time,
        null
    )
    return Uri.parse(path)
}