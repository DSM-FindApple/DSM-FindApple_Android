package com.findapple.findapple.app.features.mypage.bindingadapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.findapple.findapple.R

@BindingAdapter("lost_ct", "find_ct")
fun TextView.setPostCountText(lostCt: Int?, findCt: Int?) {
    this.text = "분실물 게시물: $lostCt 습득물 게시물: $findCt"
}

@BindingAdapter("findapple_point_img")
fun ImageView.setFindAppleImage(point: Int?) {
    when(point) {
        null, in 0..11 -> {
            setImageResource(R.drawable.ic_fineapple_smile)
        }
        in 12..40 -> {
            setImageResource(R.drawable.ic_fineapple_king)
        }
        else -> {
            setImageResource(R.drawable.img_fineapple_kingwangjjang)
        }
    }
}

@BindingAdapter("findapple_point_text")
fun TextView.setFindAppleText(point: Int?) {
    text = when(point) {
        null, in 0..11 -> {
            "파인애플왕국 국민"
        }
        in 12..40 -> {
            "파인애플왕국 국왕"
        }
        else -> {
            "파인애플국 킹왕짱 국왕"
        }
    }
}