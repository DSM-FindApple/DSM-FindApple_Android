package com.findapple.findapple.data.datasource.post

import com.findapple.findapple.data.dto.response.FindListResponse
import com.findapple.findapple.data.dto.response.LostListResponse
import io.reactivex.Single

interface PostDataSource {
    fun getLostList(): Single<LostListResponse>

    fun getFindList(): Single<FindListResponse>

    fun postFind()
}