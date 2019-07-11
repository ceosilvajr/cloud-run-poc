package com.ceosilvajr.publish

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PublishApplication

fun main(args: Array<String>) {
    runApplication<PublishApplication>(*args)
}
