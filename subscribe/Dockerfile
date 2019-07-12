# Use the official gradle/Java 8 image to create a build artifact.
# https://hub.docker.com/_/gradle
FROM gradle:jdk8 as builder

  # Copy local code to the container image.
WORKDIR /subscribe
COPY build.gradle.kts .
COPY src ./src

  # Build a release artifact.
RUN gradle build assemble

  # Use AdoptOpenJDK for base image.
  # It's important to use OpenJDK 8u191 or above that has container support enabled.
  # https://hub.docker.com/r/adoptopenjdk/openjdk8
  # https://docs.docker.com/develop/develop-images/multistage-build/#use-multi-stage-builds
FROM adoptopenjdk/openjdk8:jdk8u202-b08-alpine-slim

  # Copy the jar to the production image from the builder stage.
COPY --from=builder /subscribe/build/libs/subscribe-*.jar /subscribe.jar

  # Run the web service on container startup.
CMD ["java","-Djava.security.egd=file:/dev/./urandom","-Dserver.port=${PORT}","-jar","/subscribe.jar"]
