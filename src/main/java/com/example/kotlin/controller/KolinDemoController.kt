package com.example.kotlin.controller

import com.example.kotlin.domain.infrastructure.entity.User
import com.example.kotlin.domain.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * @author chensy
 * @since 2017/7/15.
 */
@RestController
class KolinDemoController {
    @Autowired
    lateinit var userService: UserService

    @RequestMapping("/hello")
    fun hello(@RequestParam id: Int): Int {
        return id
    }

    @RequestMapping("/index")
    fun index(): Map<String, Any> {
        var resultMap = HashMap<String, Any>()
        resultMap["status"] = true
        resultMap["code"] = 1
        resultMap["msg"] = "hello world!"
        return resultMap
    }

    @RequestMapping("/find")
    fun findUser(@RequestParam username: String): User? {
        var user = userService.findByName(username)
        print(user.toString() + " ----------")
        return user
    }
}