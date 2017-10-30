package com.example.kotlin.domain.infrastructure.model.mapper

import com.example.kotlin.domain.infrastructure.entity.User
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

/**
 * @author chensy
 * @since 2017/7/16.
 */
interface UserMapper {
    @Select("select * from User where username = #{name};select * from User where username = 'admin'")
    fun findByName(@Param("name") name: String): User

    @Insert("INSERT INTO user (username, email, password) values (#{user.username},#{user.email},#{user.password}) ")
    fun insert(@Param("user") user: User)
}