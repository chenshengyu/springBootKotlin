package com.example.kotlin.domain.infrastructure.model

import com.example.kotlin.domain.infrastructure.entity.User
import com.example.kotlin.domain.infrastructure.model.mapper.UserMapper
import com.example.kotlin.domain.model.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

/**
 * @author chensy
 * @since 2017/7/16.
 */
@Repository("userRepository")
open class UserRepositoryImpl : UserRepository {
    @Autowired
    lateinit var userMapper: UserMapper
    override fun findByName(name: String): User {
        return userMapper.findByName(name)
    }

}