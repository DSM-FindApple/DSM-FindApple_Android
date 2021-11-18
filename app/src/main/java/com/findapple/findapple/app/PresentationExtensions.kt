package com.findapple.findapple.app

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.provider.DocumentsContract
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

fun Uri.realPath(context: Context): String? {
    if(path?.startsWith("/storage") == true) {
        return this.path
    }

    val id = DocumentsContract.getDocumentId(this).split(":")[1]

    val columns = Array(1) { MediaStore.Files.FileColumns.DATA }
    val selection = MediaStore.Files.FileColumns._ID + "=" + id
    val cursor = context.contentResolver.query(MediaStore.Files.getContentUri("external"), columns, selection, null, null)
    cursor.use { cursor ->
        val columnIndex = cursor!!.getColumnIndex(columns[0])
        if(cursor.moveToFirst()) {
            return cursor.getString(columnIndex)
        }
    }
    return null
}