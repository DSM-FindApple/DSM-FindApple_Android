package com.findapple.findapple.data.datasource.post

import com.findapple.findapple.data.dto.response.FindListResponse
import com.findapple.findapple.data.dto.response.LostListResponse
import io.reactivex.Single

class PostDataSourceImpl: PostDataSource {
    override fun getLostList(): Single<LostListResponse> {
        TODO("Not yet implemented")
    }

    override fun getFindList(): Single<FindListResponse> {
        TODO("Not yet implemented")
    }
}