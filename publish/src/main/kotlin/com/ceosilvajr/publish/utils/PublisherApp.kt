package com.ceosilvajr.publish.utils

import com.google.api.core.ApiFuture
import com.google.api.core.ApiFutures
import com.google.cloud.ServiceOptions
import com.google.cloud.pubsub.v1.Publisher
import com.google.protobuf.ByteString
import com.google.pubsub.v1.ProjectTopicName
import com.google.pubsub.v1.PubsubMessage
import java.util.*
import java.util.logging.Logger

/**
 * @author ceosilvajr2gmai
 */
object PublisherApp {

    private val logger = Logger.getLogger(PublisherApp::javaClass.name)

    private val PROJECT_ID = ServiceOptions.getDefaultProjectId()

    fun execute(topicId: String, message: String): String {
        logger.info("Publisher topic $topicId")
        val topicName = ProjectTopicName.of(PROJECT_ID, topicId)
        var publisher: Publisher? = null
        val futures = ArrayList<ApiFuture<String>>()
        try {
            // Create a publisher instance with default settings bound to the topic
            publisher = Publisher.newBuilder(topicName).build()
            // convert message to bytes
            val data = ByteString.copyFromUtf8(message)
            val pubsubMessage = PubsubMessage.newBuilder().setData(data).build()
            // Schedule a message to be published. Messages are automatically batched.
            val future = publisher.publish(pubsubMessage)
            futures.add(future)
            logger.info("Message sent from publisher $message")
            // Wait on any pending requests
            val messageIds = ApiFutures.allAsList(futures).get()
            for (messageId in messageIds) {
                logger.info(messageId)
            }
            publisher?.shutdown()
            return "Message sent"
        } catch (e: Exception) {
            return "Message not sent error: $e"
        }
    }
}

