package com.sesori.null4u

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Null4uApplication

fun main(args: Array<String>) {
	runApplication<Null4uApplication>(*args)
	var a = null
}
