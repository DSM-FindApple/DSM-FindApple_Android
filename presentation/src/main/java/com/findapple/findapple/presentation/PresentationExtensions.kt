package com.findapple.findapple.presentation

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.annotation.RequiresApi
import java.io.ByteArrayOutputStream
import java.io.File
import java.util.*
import kotlin.collections.ArrayList

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