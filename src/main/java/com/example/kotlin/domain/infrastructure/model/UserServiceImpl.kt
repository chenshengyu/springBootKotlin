package com.example.kotlin.domain.infrastructure.model

import com.example.kotlin.domain.infrastructure.entity.User
import com.example.kotlin.domain.model.UserRepository
import com.example.kotlin.domain.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * @author chensy
 * @since 2017/7/16.
 */
@Service
class UserServiceImpl : UserService {
    @Autowired
    lateinit var userRepository: UserRepository

    override fun findByName(name: String): User {
        return userRepository.findByName(name)
    }

}