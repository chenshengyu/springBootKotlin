package com.example.kotlin.domain.model

import com.example.kotlin.domain.infrastructure.entity.User

/**
 * @author chensy
 * @since 2017/7/16.
 */
interface UserRepository {
    fun findByName(name: String): User

    fun insert(user: User)
}