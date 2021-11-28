package com.findapple.findapple.data.features.comment.datasource

import com.findapple.findapple.data.dto.response.CommentResponse
import io.reactivex.Single

class CommentDatasourceImpl: CommentDatasource {
    override fun getComments(): Single<List<CommentResponse>> {
        TODO("Not yet implemented")
    }
}