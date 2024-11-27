package com.sesori.null4u.service

import com.sesori.null4u.entity.User
import com.sesori.null4u.repo.UsersRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UsersService @Autowired constructor(
    private val usersRepo: UsersRepo
) {

    fun getAllUsers(): List<User> {
        return usersRepo.findAll()
    }

    fun createUser(user: User) {
        usersRepo.save(user)
    }
}