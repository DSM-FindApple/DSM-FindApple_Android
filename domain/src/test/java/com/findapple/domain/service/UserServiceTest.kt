package com.findapple.domain.service

import com.findapple.domain.BaseTest
import com.findapple.domain.entity.User
import com.findapple.domain.errorhandler.ErrorHandler
import com.findapple.domain.features.auth.repository.AuthRepository
import com.findapple.domain.features.auth.usecase.SaveUserUseCase
import com.findapple.domain.features.mypage.repository.UserRepository
import com.findapple.domain.features.mypage.usecase.GetUserUseCase
import io.reactivex.disposables.CompositeDisposable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

class UserServiceTest : BaseTest() {

    @Mock
    private lateinit var userRepository: UserRepository

    @Mock
    private lateinit var authRepository: AuthRepository

    @Mock
    private lateinit var errorHandler: ErrorHandler

    private lateinit var getUserUseCase: GetUserUseCase

    private lateinit var saveUserUseCase: SaveUserUseCase

    @Before
    fun init() {
        getUserUseCase = GetUserUseCase(userRepository, CompositeDisposable())

        saveUserUseCase = SaveUserUseCase(authRepository, CompositeDisposable())
    }

    @Test
    fun `사용자 정보 저장`() {
        val user = User(
            id = 123123,
            name = "김재원",
            profileImage = "profileimage.png"
        )
    }

}