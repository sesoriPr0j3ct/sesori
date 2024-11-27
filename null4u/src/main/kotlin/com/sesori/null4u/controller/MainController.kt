package com.sesori.null4u.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/")
class TestController() {

    @GetMapping("/test")
    fun helloWorld() = "Hello World"


}
