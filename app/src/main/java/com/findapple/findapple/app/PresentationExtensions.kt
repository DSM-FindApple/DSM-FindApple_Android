package com.findapple.findapple.app

import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import androidx.loader.content.CursorLoader
import com.findapple.findapple.BR
import com.findapple.findapple.R
import com.findapple.findapple.app.bindingadapter.RecyclerViewItem

fun Uri.toRealPath(context: Context): String {
    val proj = arrayOf(MediaStore.Images.Media.DATA)
    val loader = CursorLoader(context, this, proj, null, null, null)
    val cursor: Cursor = loader.loadInBackground()!!

    val columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
    cursor.moveToFirst()

    val result =  cursor.getString(columnIndex)

    cursor.close()

    return result
}

fun List<String>.toRecyclerViewItem() =
    this.map { it.toImageRecyclerViewItem() }

fun String.toImageRecyclerViewItem() =
    RecyclerViewItem(
        data = this,
        itemLayoutId = R.layout.item_photo,
        variableId = BR.image
    )