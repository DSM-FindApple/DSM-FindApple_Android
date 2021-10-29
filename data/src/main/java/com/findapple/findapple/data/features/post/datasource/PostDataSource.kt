package com.findapple.findapple.data.features.post.datasource

import com.findapple.findapple.data.features.post.dto.response.FindListResponse
import com.findapple.findapple.data.features.post.dto.response.LostListResponse
import com.findapple.findapple.domain.features.post.`object`.PostDataObject
import io.reactivex.Single

interface PostDataSource {
    fun getLostList(): Single<List<LostListResponse>>

    fun getFindList(): Single<List<FindListResponse>>

    fun postFind(request: PostDataObject): Single<Unit>

    fun postLost(request: PostDataObject): Single<Unit>
}