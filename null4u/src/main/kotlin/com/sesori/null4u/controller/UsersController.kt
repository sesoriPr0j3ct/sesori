package com.sesori.null4u.controller

import com.sesori.null4u.entity.User
import com.sesori.null4u.service.UsersService
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin("*")
@RequestMapping("/api/users")
class UsersController(val usersService: UsersService) {

    @GetMapping("/list")
    fun getUsers(): List<User> {
        return usersService.getAllUsers()
    }
}