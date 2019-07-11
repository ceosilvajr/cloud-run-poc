package com.ceosilvajr.publish.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author ceosilvajr@gmail.com
 */
@RestController
class MainController {

    @GetMapping("/")
    fun hello(): String {
        return "Publish endpoint works!"
    }
}
