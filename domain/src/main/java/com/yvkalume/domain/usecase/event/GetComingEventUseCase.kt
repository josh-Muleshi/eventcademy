package com.yvkalume.domain.usecase.event

import com.yvkalume.domain.entity.Event
import com.yvkalume.domain.repository.EventRepository
import com.yvkalume.domain.util.FlowUseCase
import com.yvkalume.util.Result
import com.yvkalume.util.annotation.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.MainCoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetComingEventUseCase @Inject constructor (private val repository: EventRepository, @IoDispatcher private val dispatcher: CoroutineDispatcher) : FlowUseCase<Unit, List<Event>>(dispatcher) {
    override fun execute(params: Unit): Flow<List<Event>> {
        TODO("Not yet implemented")
    }
}