package com.yvkalume.domain.usecase.club

import com.yvkalume.domain.entity.Club
import com.yvkalume.domain.repository.ClubRepository
import com.yvkalume.domain.util.FlowUseCase
import com.yvkalume.util.Result
import com.yvkalume.util.annotation.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

class GetOneClubByUidUseCase(private val repository: ClubRepository, @IoDispatcher private val dispatcher: CoroutineDispatcher) : FlowUseCase<String,Club>(dispatcher) {
    override fun execute(parameters: String): Flow<Result<Club>> {
        return repository.getOneByUid(parameters)
    }
}