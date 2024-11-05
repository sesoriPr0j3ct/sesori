package com.sesori.null4u.service

import com.sesori.null4u.entity.User
import com.sesori.null4u.repository.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UsersService @Autowired constructor(
    private val usersRepository: UsersRepository
) {

    fun getAllUsers(): List<User> {
        return usersRepository.findAll()
    }

    fun createUser(user: User): User {
        return usersRepository.save(user)
    }
}