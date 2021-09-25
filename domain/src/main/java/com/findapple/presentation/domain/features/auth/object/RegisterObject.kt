package com.findapple.presentation.domain.features.auth.`object`

import com.findapple.presentation.domain.`object`.LocationInfo
import com.findapple.presentation.domain.features.auth.entity.Auth

data class RegisterObject(val auth: Auth, val locationInfo: LocationInfo)
