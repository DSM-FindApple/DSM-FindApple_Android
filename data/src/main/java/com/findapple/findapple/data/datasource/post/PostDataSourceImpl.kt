package com.findapple.findapple.data.datasource.post

import com.findapple.findapple.data.dto.response.FindListResponse
import com.findapple.findapple.data.dto.response.LostListResponse
import com.findapple.findapple.data.remote.PostApi
import io.reactivex.Single

class PostDataSourceImpl(private val postApi: PostApi) : PostDataSource {
    override fun getLostList(): Single<LostListResponse> =
        postApi.getLostList()

    override fun getFindList(): Single<FindListResponse> =
        postApi.getFindList()
}