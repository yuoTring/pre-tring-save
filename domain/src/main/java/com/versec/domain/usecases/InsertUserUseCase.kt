package com.versec.domain.usecases

import com.versec.domain.model.UserModel
import com.versec.domain.repository.UserRepository

class InsertUserUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke(userModel: UserModel) = userRepository.insertUser(userModel)
}