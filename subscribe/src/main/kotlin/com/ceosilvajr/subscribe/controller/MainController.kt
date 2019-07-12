package com.ceosilvajr.subscribe.controller

import com.ceosilvajr.subscribe.model.PubSubMessage
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*
import java.util.logging.Logger

/**
 * @author ceosilvajr@gmail.com
 */
@RestController
class MainController {

    private val logger = Logger.getLogger(MainController::class.java.name)

    @PostMapping("/")
    fun receivePush(@RequestBody requestBody: PubSubMessage): String {
        logger.info("PubSubMessage :$requestBody")
        try {
            logger.info("Message :${String(Base64.getDecoder().decode(requestBody.message?.data ?: ""))}")
        } catch (e: Exception) {
            logger.info(e.toString())
        }
        return requestBody.toString()
    }
}
