package com.example.kotlin

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.scheduling.annotation.EnableAsync

/**
 * @author chensy
 * @since 2017/7/16.
 */
@SpringBootApplication
@ComponentScan("com.example.kotlin")
@MapperScan("com.example.kotlin.domain.infrastructure.model")
@EnableAsync
open class SpringBootKotlinApplication

fun main(args: Array<String>) {
    SpringApplication.run(SpringBootKotlinApplication::class.java, *args)
}
