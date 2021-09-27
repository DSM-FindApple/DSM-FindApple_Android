package com.findapple.data.features.post.datasource

import com.findapple.data.features.post.dto.response.FindListResponse
import com.findapple.data.features.post.dto.response.LostListResponse
import com.findapple.domain.features.post.`object`.PostDataObject
import io.reactivex.Single

interface PostDataSource {
    fun getLostList(): Single<LostListResponse>

    fun getFindList(): Single<FindListResponse>

    fun postFind(request: PostDataObject): Single<Unit>

    fun postLost(request: PostDataObject): Single<Unit>
}