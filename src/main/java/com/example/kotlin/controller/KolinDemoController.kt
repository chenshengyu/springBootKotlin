package com.example.kotlin.controller

import com.example.kotlin.domain.infrastructure.entity.User
import com.example.kotlin.domain.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Async
import org.springframework.scheduling.annotation.AsyncResult
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView
import java.util.concurrent.Future
import javax.annotation.PostConstruct

/**
 * @author chensy
 * @since 2017/7/15.
 */
@RestController
open class KolinDemoController {
    @Autowired
    lateinit var userService: UserService

    @PostConstruct
    fun init() {
        println("-----------------------")
    }

    @RequestMapping("/hello")
    fun hello(@RequestParam id: Int): Int {
        return id
    }

    @RequestMapping("/test")
    fun test(): Map<String, Any> {
        val result = java.util.HashMap<String, String>()
        val startTime = System.currentTimeMillis()
        val worker1 = worker1()
        val worker2 = worker2()
        println("await")
        result.put("worker1", worker1.get())
        result.put("worker2", worker2.get())
        result["请求耗时 = "] = (System.currentTimeMillis() - startTime).toString() + "毫秒"
        return result
    }
    @Async
    open fun worker1(): Future<String> {
        try {
            Thread.sleep(6000)
        } finally {
        }
        return AsyncResult<String>("worker1 time = 60000")
    }
    @Async
    open fun worker2(): Future<String> {
        try {
            Thread.sleep(10000)
        } finally {
        }
        return AsyncResult<String>("worker2 time = 10000")
    }

    @RequestMapping("/index")
    fun index(): Map<String, Any> {
        val resultMap = HashMap<String, Any>()
        resultMap["status"] = true
        resultMap["code"] = 1
        resultMap["msg"] = "hello world!"
        val model = ModelAndView()
        model.addObject("1", 2)
        return resultMap
    }

    @RequestMapping("/find")
    fun findUser(@RequestParam username: String): User? {
        val user = userService.findByName(username)
        print(user.toString() + " ----------")
        return user
    }
}