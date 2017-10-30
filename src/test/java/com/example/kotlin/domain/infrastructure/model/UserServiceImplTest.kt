package com.example.kotlin.domain.infrastructure.model

import com.example.kotlin.SpringBootKotlinApplication
import com.example.kotlin.domain.infrastructure.entity.User
import com.example.kotlin.domain.service.UserService
import org.assertj.core.api.Assertions
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
 * @author chensy
 * *
 * @since 2017/9/25.
 */
@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest(classes = arrayOf(SpringBootKotlinApplication::class))
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class UserServiceImplTest {
    @Autowired
    lateinit var userService: UserService

    @Test
    fun a_find() {
        val user = userService.findByName("A")
        Assertions.assertThat(user).isNull()
    }

    @Test
    fun b_methodC() {
        val user = User()
        userService.methodA(user)
    }

    @Test
    fun c_find() {
        val user = userService.findByName("A")
        println(user)
        Assertions.assertThat(user).hasFieldOrPropertyWithValue("username", "A")
    }
    @Test
    fun d_find() {
        val user = userService.findByName("B")
        println(user)
        Assertions.assertThat(user).hasFieldOrPropertyWithValue("username", "B")
    }

}