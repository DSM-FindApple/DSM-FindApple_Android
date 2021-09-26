package com.findapple.domain.features.auth.`object`

import com.findapple.domain.`object`.LocationInfo
import com.findapple.domain.features.auth.entity.Auth

data class RegisterObject(val auth: Auth, val locationInfo: LocationInfo)
