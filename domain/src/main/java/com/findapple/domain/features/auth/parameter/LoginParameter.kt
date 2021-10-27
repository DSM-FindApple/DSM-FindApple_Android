package com.findapple.domain.features.auth.parameter

import com.findapple.domain.entity.Location
import com.findapple.domain.features.auth.entity.Auth

data class LoginParameter(val auth: Auth, val location: Location)