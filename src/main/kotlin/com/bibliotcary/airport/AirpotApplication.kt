package com.bibliotcary.airport

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AirportApplication

fun main(args: Array<String>) {
    runApplication<AirportApplication>(*args)
}
