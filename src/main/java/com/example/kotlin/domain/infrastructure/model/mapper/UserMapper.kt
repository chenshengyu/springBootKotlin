package com.example.kotlin.domain.infrastructure.model.mapper

import com.example.kotlin.domain.infrastructure.entity.User
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

/**
 * @author chensy
 * @since 2017/7/16.
 */
interface UserMapper {
    @Select("select * from User where username = #{name}")
    fun findByName(@Param("name") name: String): User
}