package com.findapple.findapple.domain.auth.`object`

import com.findapple.findapple.domain.`object`.LocationInfo
import com.findapple.findapple.domain.auth.entity.Auth

data class RegisterObject(val auth: Auth, val locationInfo: LocationInfo)
