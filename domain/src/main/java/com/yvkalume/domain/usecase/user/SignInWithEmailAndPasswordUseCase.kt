package com.yvkalume.domain.usecase.user

import com.yvkalume.domain.repository.UserRepository
import com.yvkalume.domain.usecase.user.SignInWithEmailAndPasswordUseCase.*
import com.yvkalume.domain.util.CoroutineUseCase
import com.yvkalume.util.Result
import com.yvkalume.util.annotation.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class SignInWithEmailAndPasswordUseCase @Inject constructor(
    private val repository: UserRepository,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : CoroutineUseCase<SignInWithEmailParams, Boolean>(dispatcher) {
    override suspend fun execute(params: SignInWithEmailParams): Boolean {
        return repository.signInWithEmailAndPassword(
            email = params.email,
            password = params.password
        )
    }

    data class SignInWithEmailParams(val email: String, val password: String)
}


