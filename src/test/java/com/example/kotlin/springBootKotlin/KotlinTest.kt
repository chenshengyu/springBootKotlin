package com.example.kotlin.springBootKotlin

import com.example.kotlin.domain.infrastructure.entity.User

/**
 * @author chensy
 * @since 2017/7/15.
 */
fun main(args: Array<String>) {
    val extraValue = "extra"
    var user = User();
    user.email = "111";
    print(user.email)
}