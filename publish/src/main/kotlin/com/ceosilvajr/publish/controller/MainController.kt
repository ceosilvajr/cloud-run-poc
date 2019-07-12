package com.ceosilvajr.publish.controller

import com.ceosilvajr.publish.utils.PublisherApp
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

/**
 * @author ceosilvajr@gmail.com
 */
@RestController
class MainController {

    @GetMapping("/{topicId}/{message}")
    fun publish(@PathVariable topicId: String, @PathVariable message: String): String {
        return PublisherApp.execute(topicId, message)
    }
}
