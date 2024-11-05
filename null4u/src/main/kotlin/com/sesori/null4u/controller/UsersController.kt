package com.sesori.null4u.controller

import com.sesori.null4u.entity.User
import com.sesori.null4u.service.UsersService
import org.apache.coyote.Response
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UsersController(val usersService: UsersService) {

    @GetMapping("/list")
    fun getUsers(): List<User> {
        println("하하하")
        return usersService.getAllUsers()
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    fun createUser(@RequestBody user: User) {
        println("히히히")
        usersService.createUser(user)
    }
}