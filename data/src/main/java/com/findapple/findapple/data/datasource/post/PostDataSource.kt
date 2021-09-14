package com.findapple.findapple.data.datasource.post

import com.findapple.findapple.data.dto.request.PostFindRequest
import com.findapple.findapple.data.dto.request.PostLostRequest
import com.findapple.findapple.data.dto.response.FindListResponse
import com.findapple.findapple.data.dto.response.LostListResponse
import com.findapple.findapple.domain.post.`object`.PostDataObject
import io.reactivex.Single

interface PostDataSource {
    fun getLostList(): Single<LostListResponse>

    fun getFindList(): Single<FindListResponse>

    fun postFind(request: PostDataObject): Single<Unit>

    fun postLost(request: PostDataObject): Single<Unit>
}