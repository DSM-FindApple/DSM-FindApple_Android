package com.findapple.findapple.data.features.comment.remote

import com.findapple.findapple.data.dto.response.CommentResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface CommentApi {
    @GET("{commentType}/{id}")
    fun getComments(@Path("commentType")commentType: String, @Path("id")id: Long): Single<List<CommentResponse>>
}