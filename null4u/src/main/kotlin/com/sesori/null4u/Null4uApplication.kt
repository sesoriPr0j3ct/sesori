package com.sesori.null4u

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
class Null4uApplication

fun main(args: Array<String>) {
	runApplication<Null4uApplication>(*args)
}
