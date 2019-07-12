package com.ceosilvajr.subscribe.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author ceosilvajr@gmail.com
 */
@RestController
class MainController {

    @GetMapping("/")
    fun hello(): String {
        return "Subscribe endpoint works!"
    }
}
