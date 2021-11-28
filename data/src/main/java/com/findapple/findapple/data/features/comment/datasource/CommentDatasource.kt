package com.findapple.findapple.data.features.comment.datasource

import com.findapple.findapple.data.dto.response.CommentResponse
import io.reactivex.Single

interface CommentDatasource {
    fun getComments(): Single<List<CommentResponse>>
}