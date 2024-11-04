package com.sesori.null4u.controller

import com.sesori.null4u.entity.Test
import com.sesori.null4u.service.TestService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/")
class TestController(private val testService: TestService) {

    @GetMapping("/test")
    fun getAllTests(): ResponseEntity<List<Test>> {
        val tests = testService.getAllTests()
        return ResponseEntity(tests, HttpStatus.OK)
    }


}
