package com.oing.bibbi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BibbiApplication

fun main(args: Array<String>) {
	runApplication<BibbiApplication>(*args)
}
