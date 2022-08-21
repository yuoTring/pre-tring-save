package com.versec.domain.usecases

import com.versec.domain.repository.UserRepository

class GetUserUseCase(private val userRepository: UserRepository)
{
    suspend operator fun invoke() = userRepository.getAllUser()
}