package com.findapple.findapple.domain.service

import com.findapple.findapple.domain.BaseTest
import com.findapple.findapple.domain.entity.User
import com.findapple.findapple.domain.features.auth.repository.AuthRepository
import com.findapple.findapple.domain.features.auth.usecase.SaveUserUseCase
import com.findapple.findapple.domain.features.mypage.repository.UserRepository
import com.findapple.findapple.domain.features.mypage.usecase.GetUserUseCase
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`

class UserServiceTest : BaseTest() {

    @Mock
    private lateinit var userRepository: UserRepository

    @Mock
    private lateinit var authRepository: AuthRepository

    private lateinit var getUserUseCase: GetUserUseCase

    private lateinit var saveUserUseCase: SaveUserUseCase

    @Before
    fun init() {
        getUserUseCase = GetUserUseCase(userRepository, CompositeDisposable())

        saveUserUseCase = SaveUserUseCase(authRepository, CompositeDisposable())
    }

    @Test
    fun `사용자 정보 저장 성공`() {
        val user = User(
            id = 123123,
            name = "김재원",
            profileImage = "profileimage.png"
        )
        `when`(authRepository.saveUserInfo(user))
            .thenReturn(Single.just(Unit))

        saveUserUseCase.create(user)
            .test().assertValue(Unit)
    }

    @Test
    fun `사용자 정보 불러오기 성공`() {
        val user = User(
            id = 123123,
            name = "김재원",
            profileImage = "profileimage.png"
        )
        `when`(userRepository.getUserInfo())
            .thenReturn(Single.just(user))

        getUserUseCase.create(Unit)
            .test().assertValue(user)
    }

}