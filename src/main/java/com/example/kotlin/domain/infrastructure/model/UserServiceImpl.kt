package com.example.kotlin.domain.infrastructure.model

import com.example.kotlin.domain.infrastructure.entity.User
import com.example.kotlin.domain.model.UserRepository
import com.example.kotlin.domain.service.UserService
import org.springframework.aop.framework.AopContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.EnableTransactionManagement
import org.springframework.transaction.annotation.Isolation
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import org.springframework.aop.framework.AopContext.currentProxy


/**
 * @author chensy
 * @since 2017/7/16.
 */
@Service
@Transactional
class UserServiceImpl : UserService {
    @Autowired
    lateinit var userRepository: UserRepository

    override fun findByName(name: String): User {
        return userRepository.findByName(name)
    }

    override fun methodA(user: User) {
        val user1 = User()
        user1.username = "A"
        user1.password = "A"
        user1.email = "A"
        userRepository.insert(user1)
        (AopContext.currentProxy() as UserService).methodB(user)

    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    override fun methodB(user: User) {
        val user1 = User()
        user1.username = "B"
        user1.password = "B"
        user1.email = "B"
        userRepository.insert(user1)
        throw RuntimeException(" service fail.")

    }

    override fun methodC(user: User) {
        methodA(user)
    }

}