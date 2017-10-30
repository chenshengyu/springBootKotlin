package com.example.kotlin.domain.service

import com.example.kotlin.domain.infrastructure.entity.User

/**
 * @author chensy
 * @since 2017/7/16.
 */
interface UserService {
    fun findByName(name: String): User?

    fun methodA(user: User)

    fun methodB(user: User)

    fun methodC(user: User)
}