package com.ceosilvajr.subscribe.model

/**
 * @author ceosilvajr@gmail.com
 */
data class PubSubMessage(
        var message: Message? = null,
        var subscription: String? = ""
)

data class Message(
        var data: String? = "",
        var messageId: String? = "",
        var publishTime: String? = ""
)
