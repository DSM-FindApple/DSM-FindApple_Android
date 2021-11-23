package com.findapple.findapple.app.features.mypage.bindingadapter

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("lost_ct", "find_ct")
fun TextView.setPostCountText(lostCt: Int?, findCt: Int?) {
    this.text = "분실물 게시물: $lostCt 습득물 게시물: $findCt"
}