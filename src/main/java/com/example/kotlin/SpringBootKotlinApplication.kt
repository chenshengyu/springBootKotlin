package com.example.kotlin

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.transaction.annotation.EnableTransactionManagement

/**
 * @author chensy
 * @since 2017/7/16.
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.example.kotlin.domain.infrastructure.model")
@EnableAsync
open class SpringBootKotlinApplication

fun main(args: Array<String>) {
    SpringApplication.run(SpringBootKotlinApplication::class.java, *args)
}
