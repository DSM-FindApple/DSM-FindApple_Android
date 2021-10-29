package com.findapple.findapple.domain.features.auth.parameter

import com.findapple.findapple.domain.entity.Location
import com.findapple.findapple.domain.features.auth.entity.Auth

data class LoginParameter(val auth: Auth, val location: Location)